package com.bonc.activiti.web.controller;

import com.bonc.activiti.core.ActLeaveTaskManage;
import com.bonc.activiti.web.dto.IsAgreeManaDto;
import com.bonc.activiti.web.dto.IsSubmissionDto;
import com.bonc.activiti.web.dto.MyTasksDto;
import com.bonc.activiti.web.dto.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-13 11:19
 */
@RestController
@RequestMapping("/task/leave")
@Api(description = "请假流程任务接口")
public class ActLeaveTaskController {

    @Autowired
    private ActLeaveTaskManage manage;

    @PostMapping
    @ApiOperation(value = "启动请假流程")
    public Result startLeaveProcess(String processDefinitionKey) {
        return manage.startLeaveProcess(processDefinitionKey);
    }

    @PostMapping("/submission")
    @ApiOperation(value = "请假申请，1: 提交，0: 不提交")
    public Result isSubmission(IsSubmissionDto dto) {
        return manage.isSubmission(dto);
    }

    @PostMapping("/manager")
    @ApiOperation(value = "经理审批，1: 同意，0: 拒绝")
    public Result isAgreeMana(IsAgreeManaDto dto) {
        return manage.isAgreeMana(dto);
    }

    @PostMapping("/hr")
    @ApiOperation(value = "人事审批")
    public Result isAgreeHr(IsAgreeManaDto dto) {
        return manage.isAgreeHr(dto);
    }

    @GetMapping("/my-tasks")
    public Result myTasks(MyTasksDto dto) {
        return manage.myTasks(dto);
    }

}
