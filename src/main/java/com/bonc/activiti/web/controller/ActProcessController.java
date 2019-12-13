package com.bonc.activiti.web.controller;

import com.bonc.activiti.core.ActProcessManage;
import com.bonc.activiti.web.dto.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-13 11:17
 */
@RestController
@RequestMapping("/process")
@Api(description = "工作流流程服务")
public class ActProcessController {


    @Autowired
    private ActProcessManage actProcessManage;

    @PostMapping
    @ApiOperation("部署流程定义")
    public Result deployProcess(MultipartFile file) {
        return actProcessManage.deployProcess(file);
    }
}
