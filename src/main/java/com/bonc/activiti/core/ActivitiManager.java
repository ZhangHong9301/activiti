package com.bonc.activiti.core;

import com.bonc.activiti.web.dto.Result;
import com.bonc.activiti.web.dto.TaskDto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-06 11:14
 */
public interface ActivitiManager {

    Result deploy(MultipartFile file);

    /**
     * @description: 启动流程
     * @param: [taskDto, userId]  
     * @Return: com.bonc.activiti.web.dto.Result
     */
    Result processStart(TaskDto taskDto, String userId);

    /**
     * @description: 获取代办任务
     * @param: [userId, page, size]
     * @Return: com.bonc.activiti.web.dto.Result
     */
    Result getTask(String userId, Integer page, Integer size);

    Result completeTask(String taskId, String note, HttpServletRequest request);
}
