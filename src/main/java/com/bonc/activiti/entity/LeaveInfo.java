package com.bonc.activiti.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-06 16:27
 */
@Data
@Accessors(chain = true)
public class LeaveInfo {

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "流程实例id")
    private String instanceId;

    @ApiModelProperty(value = "开始日期")
    private String startTime;

    @ApiModelProperty(value = "结束日期")
    private String endTime;

    @ApiModelProperty(value = "请假原由")
    private String reason;

    @ApiModelProperty("任务id")
    String taskId;

    @ApiModelProperty("任务名")
    String taskName;

    @ApiModelProperty("流程定义id")
    String processDefId;

    @ApiModelProperty("任务创建时间")
    Date taskCreateTime;
}
