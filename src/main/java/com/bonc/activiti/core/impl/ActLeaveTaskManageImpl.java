package com.bonc.activiti.core.impl;

import com.bonc.activiti.core.ActLeaveTaskManage;
import com.bonc.activiti.entity.ActConstant;
import com.bonc.activiti.entity.LeaveConverter;
import com.bonc.activiti.entity.LeaveInfo;
import com.bonc.activiti.mapper.LeaveInfoMapper;
import com.bonc.activiti.util.UUIDUtil;
import com.bonc.activiti.web.dto.IsAgreeManaDto;
import com.bonc.activiti.web.dto.IsSubmissionDto;
import com.bonc.activiti.web.dto.MyTasksDto;
import com.bonc.activiti.web.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-23 11:53
 */
@Service
@Slf4j
public class ActLeaveTaskManageImpl implements ActLeaveTaskManage {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private LeaveInfoMapper leaveInfoMapper;

    /**
     * 启动请假流程
     *
     * @param processDefinitionKey
     */
    @Override
    public Result startLeaveProcess(String processDefinitionKey) {
        String userId = "manji";
        // 用请假信息表的主键作为businessKey，连接业务数据和流程数据
        String businessKey = UUIDUtil.createUUID();
        identityService.setAuthenticatedUserId(userId);
        Map<String, Object> variables = new HashMap<>();
        variables.put(ActConstant.APPLICANT, userId);
        ProcessInstance instance =
                runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey, variables);
        runtimeService.setProcessInstanceName(instance.getId(), userId + "的请假流程");
        ProcessInstance instance1 = runtimeService.createProcessInstanceQuery()
                .processInstanceId(instance.getId())
                .singleResult();
        log.info("流程: {},ID: {} 已启动", instance1.getName(), instance1.getId());
        return Result.success();
    }

    /**
     * 请假申请
     *
     * @param dto
     */
    @Override
    @Transactional
    public Result isSubmission(IsSubmissionDto dto) {
        Map<String, Object> variables = new HashMap<>();
        variables.put(ActConstant.ISSUBMISSION, dto.getIsTrue());
        variables.put(ActConstant.MANAGER, dto.getUserId());
        Task task = getTask(dto.getProcessInstanceId());
        ProcessInstance instance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(dto.getProcessInstanceId())
                .singleResult();
        String businessKey = instance.getBusinessKey();
        LeaveInfo leaveInfo = new LeaveInfo();
        leaveInfo.setId(businessKey);
        leaveInfo.setInstanceId(dto.getProcessInstanceId());
        leaveInfo.setTaskId(task.getId());
        leaveInfo.setTaskName(task.getName());
        leaveInfo.setUserId(task.getAssignee());
        leaveInfo.setStartTime(dto.getStartTime());
        leaveInfo.setEndTime(dto.getEndTime());
        leaveInfo.setReason(dto.getReason());
        // 第一次提交时，新增一条记录；请假申请被打回时，更新之前的记录
        LeaveConverter c = leaveInfoMapper.getLeaveInfo(businessKey);
        if (c == null) {
            leaveInfoMapper.addLeaveInfo(leaveInfo);
        } else {
            log.info("请假申请被打回，更改请假信息");
            // leaveInfoMapper.updateLeaveInfo(leaveInfo);
        }
        log.info("申请人: {}", task.getAssignee());
        taskService.complete(task.getId(), variables);
        Task task1 = getTask(dto.getProcessInstanceId());
        if (task1 != null) {
            log.info("部门领导审批人: {}", task1.getAssignee());
        } else {
            log.info("请假申请流程: {} 已结束", dto.getProcessInstanceId());
        }
        return Result.success();
    }

    private Task getTask(String processInstanceId) {
        return taskService.createTaskQuery()
                .processInstanceId(processInstanceId)
                .singleResult();
    }

    /**
     * 经理审批
     *
     * @param dto
     */
    @Override
    public Result isAgreeMana(IsAgreeManaDto dto) {
        Map<String, Object> variables = new HashMap<>();
        variables.put(ActConstant.HR, dto.getUserId());
        variables.put(ActConstant.ISAGREEMANA, dto.getIsTrue());
        Task task = getTask(dto.getProcessInstanceId());
        log.info("审批人: {}", task.getAssignee());
        taskService.complete(task.getId(), variables);
        Task task1 = getTask(dto.getProcessInstanceId());
        if ("1".equals(dto.getIsTrue())) {
            log.info("人事审批人: {}", task1.getAssignee());
        } else {
            log.info("打回到请假申请，请假人: {}", task1.getAssignee());
        }
        return Result.success();
    }

    /**
     * 人事审批
     *
     * @param dto
     */
    @Override
    public Result isAgreeHr(IsAgreeManaDto dto) {
        Map<String, Object> variables = new HashMap<>();
        variables.put(ActConstant.ISAGREEHR, dto.getIsTrue());
        Task task = getTask(dto.getProcessInstanceId());
        log.info("人事审批人: {}", task.getAssignee());
        taskService.complete(task.getId(), variables);
        Task task1 = getTask(dto.getProcessInstanceId());
        if ("1".equals(dto.getIsTrue())) {
            log.info("请假流程: {} 所有审批已完成", dto.getProcessInstanceId());
        } else {
            log.info("打回到请假申请，请假人: {}", task1.getAssignee());
        }
        return Result.success();
    }

    /**
     * 我的待办
     *
     * @param dto
     */
    @Override
    public Result myTasks(MyTasksDto dto) {
        List<Task> tasks;
        if (dto.getName() != null) {
            tasks = taskService.createTaskQuery()
                    .taskName(dto.getName())
                    .orderByTaskCreateTime()
                    .asc()
                    .listPage(dto.getPage(), dto.getSize());
        } else if (dto.getUserId() != null) {
            tasks = taskService.createTaskQuery()
                    .taskAssignee(dto.getUserId())
                    .orderByTaskCreateTime()
                    .asc()
                    .listPage(dto.getPage(), dto.getSize());
        } else {
            tasks = taskService.createTaskQuery()
                    .orderByTaskCreateTime()
                    .asc()
                    .listPage(dto.getPage(), dto.getSize());
        }
        List<LeaveInfo> leaveInfos = new ArrayList<>();

        for (Task task : tasks) {
            LeaveInfo info = new LeaveInfo();
            info.setInstanceId(task.getProcessInstanceId());
            info.setTaskId(task.getId());
            info.setTaskName(task.getName());
            info.setTaskCreateTime(task.getCreateTime());
            info.setProcessDefId(task.getProcessDefinitionId());
            leaveInfos.add(info);
        }
        return Result.success(leaveInfos);
    }
}
