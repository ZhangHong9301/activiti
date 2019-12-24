package com.bonc.activiti.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-24 9:34
 */
@Data
public class MyTasksDto {

    @ApiModelProperty(value = "用户id")
    public String userId;

    @ApiModelProperty(value = "任务名称")
    public String name;

    @ApiModelProperty(value = "页数", example = "0")
    private Integer page;

    @ApiModelProperty(value = "记录数", example = "10")
    private Integer size;
}
