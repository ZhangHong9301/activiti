package com.bonc.activiti.entity;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-20 17:42
 */
public interface ActConstant {


    /**
     * 员工申请执行人变量名称
     */
    String APPLICANT = "applicant";

    /**
     * 员工是否提交申请变量名称，1 通过， 0 拒绝
     */
    String ISSUBMISSION = "isSubmission";

    /**
     * 经理审批执行人变量名称
     */
    String MANAGER = "manager";

    /**
     * 经理审批条件名称
     */
    String ISAGREEMANA = "isAgreeMana";

    /**
     * 人事审批执行人变量名称
     */
    String HR = "hr";

    /**
     * 人事审批条件名称
     */
    String ISAGREEHR = "isAgreeHr";
}
