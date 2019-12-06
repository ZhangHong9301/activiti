package com.bonc.activiti.web.controller;

import com.bonc.activiti.core.ActivitiManager;
import com.bonc.activiti.web.dto.Result;
import com.bonc.activiti.web.dto.TaskDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        Object username = request.getSession().getAttribute("username");
        String userId = "zhanghong";
        return activitiManager.processStart(taskDto, userId);
    }

    @PostMapping("/task")
    @ApiOperation(value = "代办任务")
    public Result getTask(Integer page, Integer size, HttpServletRequest request) {
        // 获取用户信息
        // 校验用户权限
        String userId = "zhanghong";
        return activitiManager.getTask(userId, page, size);
    }

}
