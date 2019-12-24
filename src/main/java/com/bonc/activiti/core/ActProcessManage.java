package com.bonc.activiti.core;

import com.bonc.activiti.web.dto.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-13 11:26
 */
public interface ActProcessManage {

    /**
     * @description: 部署流程定义
     * @param: [file]
     * @Return: com.bonc.activiti.web.dto.Result
     */
    Result deployProcess(MultipartFile file);

    /**
     * 流程追踪
     */
    void processTracking(String processInstanceId, HttpServletResponse response) throws IOException;

    /**
     * 流程定义图
     */
    void processDefImage(String processDefinitionId, HttpServletResponse response) throws IOException;
}
