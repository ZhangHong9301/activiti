package com.bonc.activiti.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-18 16:56
 */
@Data
public class CompleteTaskDto {

    @ApiModelProperty(value = "审批人", example = "蛮大人")
    private String userId;

    @ApiModelProperty(value = "变量名称，deptleaderapprove，hrapprove,reapply(销假),isSubmission,isAgree", example = "deptleaderapprove")
    private String variablesName;

    @ApiModelProperty(value = "任务id")
    private String taskId;

    @ApiModelProperty(value = "是否通过,true/false", example = "true")
    private String isTrue;

}
