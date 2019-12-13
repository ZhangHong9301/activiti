package com.bonc.activiti.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.activiti.engine.task.Task;

import java.io.Serializable;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-09 15:21
 */
@Data
public class LeaveConverter {

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

    Task task;
}
