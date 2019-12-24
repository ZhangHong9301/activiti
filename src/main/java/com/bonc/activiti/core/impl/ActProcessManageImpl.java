package com.bonc.activiti.core.impl;

import com.bonc.activiti.core.ActProcessManage;
import com.bonc.activiti.util.HttpUtils;
import com.bonc.activiti.web.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.bpmn.model.Process;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Autowired
    private HistoryService historyService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private TaskService taskService;


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
            Deployment deploy = repositoryService.createDeployment()
                    .addInputStream(filename, inputStream)
                    .name("请假流程")
                    .deploy();
            log.info("deploy end.\n部署ID: [{}]\n部署名称: [{}]", deploy.getId(), deploy.getName());
            return Result.success();
        } catch (IOException e) {
            e.printStackTrace();
            return Result.fail();
        }
    }

    /**
     * 流程追踪，需先判断流程是否已结束，如果已结束就返回流程
     *
     * @param processInstanceId
     * @param response
     */
    @Override
    public void processTracking(String processInstanceId, HttpServletResponse response) throws IOException {
        Task task = getTask(processInstanceId);
        if (task == null) {
            throw new RuntimeException("流程已结束");
        }
        ProcessDefinition processDefinition =
                repositoryService.getProcessDefinition(task.getProcessDefinitionId());
        BpmnModel bpmnModel = repositoryService.getBpmnModel(task.getProcessDefinitionId());
        // ID 为 流程定义Key
        Process process = bpmnModel.getProcessById(processDefinition.getKey());
        // 流程节点ID
        FlowElement flowElement = process.getFlowElement(task.getTaskDefinitionKey());

        DefaultProcessDiagramGenerator generator = new DefaultProcessDiagramGenerator();
        List<String> highLightedActivities = new ArrayList<>();
        highLightedActivities.add(flowElement.getId());
        // 生成图片
        InputStream inputStream = generator.generateDiagram(bpmnModel, "png",
                highLightedActivities,
                Collections.emptyList(),
                "宋体",
                "宋体",
                "宋体",
                null,
                2.0);
        ServletOutputStream outputStream = response.getOutputStream();
        HttpUtils.copyImageStream(inputStream, outputStream);
    }

    private Task getTask(String processInstanceId) {
        return taskService.createTaskQuery()
                .processInstanceId(processInstanceId)
                .singleResult();
    }

    /**
     * 流程定义图
     *
     * @param processDefinitionId
     * @param response
     */
    @Override
    public void processDefImage(String processDefinitionId, HttpServletResponse response) throws IOException {
        if (StringUtils.isBlank(processDefinitionId)) {
            throw new RuntimeException("processDefinitionId 不能为空!");
        }

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionId(processDefinitionId)
                .singleResult();
        InputStream inputStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId()
                , processDefinition.getDiagramResourceName());
        ServletOutputStream outputStream = response.getOutputStream();
        HttpUtils.copyImageStream(inputStream, outputStream);

    }
}
