package com.bonc.activiti.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-18 16:56
 */
@Data
@Accessors(chain = true)
public class CompleteTaskDto {

    @ApiModelProperty(value = "下一任务办理人", example = "蛮大人")
    private String userId;

    // @ApiModelProperty(value = "变量名称，deptleaderapprove，hrapprove,reapply(销假),isSubmission,isAgree", example = "deptleaderapprove")
    // private String condition;

    // @ApiModelProperty(value = "任务id")
    // private String taskId;

    @ApiModelProperty(value = "条件,true/false", example = "true")
    private String isTrue;

    @ApiModelProperty(value = "流程实例id")
    private String processInstanceId;

}
