package com.bonc.activiti.core;

import com.bonc.activiti.web.dto.IsAgreeManaDto;
import com.bonc.activiti.web.dto.IsSubmissionDto;
import com.bonc.activiti.web.dto.MyTasksDto;
import com.bonc.activiti.web.dto.Result;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-23 11:52
 */
public interface ActLeaveTaskManage {

    /**
     * 启动请假流程
     *
     * @param processDefinitionKey
     */
    Result startLeaveProcess(String processDefinitionKey);

    /**
     * 请假申请
     */
    Result isSubmission(IsSubmissionDto dto);

    /**
     * 经理审批
     */
    Result isAgreeMana(IsAgreeManaDto dto);

    /**
     * 人事审批
     */
    Result isAgreeHr(IsAgreeManaDto dto);

    /**
     * 我的待办
     */
    Result myTasks(MyTasksDto dto);
}
