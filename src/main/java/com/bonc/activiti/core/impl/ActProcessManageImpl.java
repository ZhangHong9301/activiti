package com.bonc.activiti.core.impl;

import com.bonc.activiti.core.ActProcessManage;
import com.bonc.activiti.web.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-13 11:28
 */
@Service
@Slf4j
public class ActProcessManageImpl implements ActProcessManage {

    @Autowired
    private RepositoryService repositoryService;

    /**
     * @param file
     * @description: 部署流程定义
     * @param: [file]
     * @Return: com.bonc.activiti.web.dto.Result
     */
    @Override
    public Result deployProcess(MultipartFile file) {
        log.info("deploy start ...");
        String filename = file.getOriginalFilename();
        try {
            InputStream inputStream = file.getInputStream();
            Deployment deploy = repositoryService.createDeployment().addInputStream(filename, inputStream).deploy();
            log.info("deploy end.\n部署ID: [{}]\n部署名称: [{}]", deploy.getId(), deploy.getName());
            return Result.success();
        } catch (IOException e) {
            e.printStackTrace();
            return Result.fail();
        }
    }
}
