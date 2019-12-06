package com.bonc.activiti.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-06 16:27
 */
@Data
public class LeaveInfo {

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "流程id")
    private String instanceId;

    @ApiModelProperty(value = "开始日期")
    private String startTime;

    @ApiModelProperty(value = "结束日期")
    private String endTime;

    @ApiModelProperty(value = "请假原由")
    private String reason;
}
