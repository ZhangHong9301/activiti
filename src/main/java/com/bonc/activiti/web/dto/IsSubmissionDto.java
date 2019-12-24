package com.bonc.activiti.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-23 15:20
 */
@Data
public class IsSubmissionDto {

    @ApiModelProperty(value = "下一任务办理人", example = "蛮大人")
    private String userId;

    @ApiModelProperty(value = "条件,1/0", example = "1")
    private String isTrue;

    @ApiModelProperty(value = "流程实例id")
    private String processInstanceId;

    @ApiModelProperty(value = "开始日期", example = "2019-12-23 08:00:00")
    private String startTime;

    @ApiModelProperty(value = "结束日期", example = "2019-12-23 23:00:00")
    private String endTime;

    @ApiModelProperty(value = "请假原由", example = "Let me go!")
    private String reason;
}
