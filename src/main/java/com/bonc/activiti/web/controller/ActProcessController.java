package com.bonc.activiti.web.controller;

import com.bonc.activiti.core.ActProcessManage;
import com.bonc.activiti.web.dto.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-13 11:17
 */
@RestController
@RequestMapping("/process")
@Api(description = "工作流流程接口，所有流程定义的CRUD")
public class ActProcessController {


    @Autowired
    private ActProcessManage actProcessManage;

    @PostMapping
    @ApiOperation("部署流程定义")
    public Result deployProcess(MultipartFile file) {
        return actProcessManage.deployProcess(file);
    }

    @PostMapping("/tracking/{processInstanceId}")
    @ApiOperation("流程追踪")
    public void processTracking(@PathVariable String processInstanceId, HttpServletResponse response) throws IOException {
        actProcessManage.processTracking(processInstanceId, response);
    }

    @GetMapping("/def/{processDefinitionId}")
    public void processDefImage(@PathVariable String processDefinitionId, HttpServletResponse response) throws IOException {
        actProcessManage.processDefImage(processDefinitionId, response);

    }
}
