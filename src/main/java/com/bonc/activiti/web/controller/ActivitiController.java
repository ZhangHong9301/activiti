package com.bonc.activiti.web.controller;

import com.bonc.activiti.core.ActivitiManager;
import com.bonc.activiti.web.dto.CompleteTaskDto;
import com.bonc.activiti.web.dto.Result;
import com.bonc.activiti.web.dto.RuntimeTaskDto;
import com.bonc.activiti.web.dto.TaskDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-06 10:27
 */
@RestController
@Api(description = "工作流服务")
@RequestMapping("/activiti")
public class ActivitiController {

    @Autowired
    private ActivitiManager activitiManager;

    @PostMapping
    @ApiOperation(value = "部署流程定义")
    public Result deploy(MultipartFile file) {
        return activitiManager.deploy(file);
    }

    @PostMapping("/process")
    @ApiOperation(value = "启动流程", notes = "用户提交申请")
    public Result processStart(TaskDto taskDto, HttpServletRequest request) {

        return activitiManager.processStart(taskDto);
    }

    @PostMapping("/task")
    @ApiOperation(value = "待办任务")
    public Result getTask(RuntimeTaskDto dto, HttpServletRequest request) {

        return activitiManager.getTask(dto);
    }

    @PostMapping("/task/task-id")
    @ApiOperation(value = "完成任务")
    public Result completeTask(CompleteTaskDto dto, HttpServletRequest request) {
        return activitiManager.completeTask(dto, request);
    }

    @PostMapping("/task/history")
    @ApiOperation("历史任务查询")
    public Result historyTask(String userId, Integer page, Integer size) {
        return activitiManager.historyTask(userId, page, size);
    }
    //查看历史
    //查看历史申请
    //查看历史审批
}
