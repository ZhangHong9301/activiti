package com.bonc.activiti.core;

import com.bonc.activiti.web.dto.Result;
import org.springframework.web.multipart.MultipartFile;

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
}
