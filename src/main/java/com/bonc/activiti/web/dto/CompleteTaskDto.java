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

    @ApiModelProperty(value = "请假人", example = "zhanghong")
    private String userId;

    @ApiModelProperty(value = "任务id")
    private String taskId;

    @ApiModelProperty(value = "是否通过", example = "true")
    private String isTrue;

}
