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


    @ApiModelProperty(value = "开始日期")
    private String startTime;

    @ApiModelProperty(value = "结束日期")
    private String endTime;

    @ApiModelProperty(value = "请假原由")
    private String reason;
}
