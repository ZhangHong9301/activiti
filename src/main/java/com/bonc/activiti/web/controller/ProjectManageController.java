package com.bonc.activiti.web.controller;

import com.bonc.activiti.service.ProjectManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/project")
@Api(value = "年度计划")
public class ProjectManageController {


    private static final Logger logger = LoggerFactory.getLogger(ProjectManageController.class);

    @Autowired
    private ProjectManageService projectManageService;

    @PostMapping
    @ApiOperation(value = "导入决算审计项目")
    public String importProject(@RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        logger.info("进入导入接口");
//        return "lllll" + file.getOriginalFilename();
//         return projectManageService.getString(file);
               return projectManageService.importProject(file);
    }


    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation(value = "导入决算审计项目")
    public Object getProject() throws IOException {
        return projectManageService.getProject();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/test")
    public String test(String fileName, String type) {
        return "It's " + fileName + " , fileName : " + type + "";
    }


}
