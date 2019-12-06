package com.bonc.activiti.core;

import com.bonc.activiti.entity.LeaveInfo;
import com.bonc.activiti.mapper.LeaveInfoMapper;
import com.bonc.activiti.util.UUIDUtil;
import com.bonc.activiti.web.dto.Result;
import com.bonc.activiti.web.dto.TaskDto;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-06 11:17
 */
@Service
public class ActivitiManagerImpl implements ActivitiManager {

    public static final Logger LOGGER = LoggerFactory.getLogger(ActivitiManagerImpl.class);

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private LeaveInfoMapper leaveInfoMapper;

    @Override
    public Result deploy(MultipartFile file) {
        LOGGER.info("deploy start ...");
        String filename = file.getOriginalFilename();
        try {
            InputStream inputStream = file.getInputStream();
            repositoryService.createDeployment().addInputStream(filename, inputStream).deploy();
            LOGGER.info("deploy end");
            return Result.success();
        } catch (IOException e) {
            e.printStackTrace();
            return Result.fail();
        }
    }

    @Override
    public Result processStart(TaskDto taskDto, String userId) {
        LeaveInfo leaveInfo = new LeaveInfo();
        String uuid = UUIDUtil.createUUID();
        leaveInfo.setId(uuid);
        leaveInfo.setUserId(userId);
        leaveInfo.setStartTime(taskDto.getStartTime());
        leaveInfo.setEndTime(taskDto.getEndTime());
        leaveInfo.setReason(taskDto.getReason());
        // 用请假信息表的主键作为businessKey，连接业务数据和流程数据
        String businessKey = uuid;
        Map<String, Object> variables = new HashMap<>();
        variables.put("applyUserId", userId);
        identityService.setAuthenticatedUserId(userId);
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("leave", businessKey, variables);
        LOGGER.info("流程 [{}] 已启动", instance.getId());
        leaveInfo.setInstanceId(instance.getId());
        leaveInfoMapper.addLeaveInfo(leaveInfo);
        return Result.success();
    }

    /**
     * @param userId
     * @param page
     * @param size
     * @description: 获取代办任务
     * @param: [userId, page, size]
     * @Return: com.bonc.activiti.web.dto.Result
     */
    @Override
    public Result getTask(String userId, Integer page, Integer size) {
        //TODO
        return null;
    }
}
