package com.bonc.activiti.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-19 10:09
 */
@Data
public class RuntimeTaskDto {


    @ApiModelProperty(value = "页数", example = "0")
    private Integer page;

    @ApiModelProperty(value = "记录数", example = "10")
    private Integer size;

    @ApiModelProperty(value = "任务组:部门经理,人事", notes = "xxx")
    private String candidateGroup;

    @ApiModelProperty(value = "分配到任务的人", example = "唐三")
    private String assignee;

}
