package com.bonc.activiti.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-23 15:54
 */
@Data
public class IsAgreeManaDto {

    @ApiModelProperty(value = "下一任务办理人", example = "海问香")
    private String userId;

    @ApiModelProperty(value = "条件,1/0", example = "1")
    private String isTrue;

    @ApiModelProperty(value = "流程实例id")
    private String processInstanceId;
}
