package com.bonc.activiti.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-06 15:53
 */
@Data
public class TaskDto {


    @ApiModelProperty(value = "开始日期", example = "2019-12-19 08:00:00")
    private String startTime;

    @ApiModelProperty(value = "结束日期", example = "2019-12-19 23:00:00")
    private String endTime;

    @ApiModelProperty(value = "请假原由", example = "Let me go!")
    private String reason;

    @ApiModelProperty(value = "请假人", example = "zhanghong")
    private String userId;

    // @ApiModelProperty(value = "变量名称,applicant,userId", example = "applicant")
    // private String variableName;

    @ApiModelProperty(value = "流程定义键")
    private String processDefinitionKey;
}
