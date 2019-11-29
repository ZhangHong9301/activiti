package com.bonc.activiti.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class AudFinalAccount implements Serializable {
    private String id;

    /**
     * 申请编号
     */
    private String appNo;

    /**
     * 项目编号
     */
    private String projectNo;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目类型,字典类型:project_type;0:全省,1:独立
     */
    private String projectType;

    /**
     * 公司代码
     */
    private String companyNo;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 省公司项目经理姓名
     */
    private String proLeaderName;

    /**
     * 省公司项目经理OA账户
     */
    private String proLeaderOaNo;

    /**
     * 地市公司项目经理姓名
     */
    private String cityLeaderName;

    /**
     * 地市公司项目经理OA账户
     */
    private String cityLeaderOaNo;

    /**
     * 投资计划金额(元)
     */
    private BigDecimal investmentPlanAmount;

    /**
     * 计划办结时间
     */
    private String planEndTime;

    /**
     * 年度
     */
    private String projectYear;

    /**
     * 年度计划导入时间
     */
    private String operatorTime;

    /**
     * 项目状态,字典类型:project_status_type;1:未送审,2:审计中,3:已审结,4:已作废
     */
    private String projectStatus;

    /**
     * 项目所在流程节点id
     */
    private String procNodeId;

    /**
     * 校验状态;0:失败,1:成功
     */
    private String checkStatus;

    /**
     * 工程类型
     */
    private String engineerType;

    /**
     * 送审金额
     */
    private BigDecimal eaAmount;

    /**
     * 送审时间
     */
    private String eaTime;

    /**
     * 委托书id
     */
    private String attorneyId;

    /**
     * 下一步审批人
     */
    private String assignId;

    /**
     * 当前办理操作类型,字典类型:approval_cur_type;1:同意,0:退回,4:废弃
     */
    private String approvalCur;

    /**
     * 超支/节约比例
     */
    private BigDecimal overRatio;

    /**
     * 流程实例
     */
    private String fiId;

    /**
     * 发起时间
     */
    private String createTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 审计进度
     */
    private String auditProcess;

    /**
     * 问题个数
     */
    private String problemNum;

    /**
     * 请输入正式报告文号
     */
    private String audReportNo;

    /**
     * 正式报告发文时间
     */
    private String audReportCreateTime;

    /**
     * 审计时限(天)
     */
    private String auditDayNum;

    /**
     * 审计资料是否超时
     */
    private String auditMaterialTimeoutFlg;

    /**
     * 超时天数
     */
    private String auditMaterialTimeoutNum;

    /**
     * 审计是否超时
     */
    private String auditTimeoutFlg;

    /**
     * 审核超时天数
     */
    private String auditTimeoutNum;

    /**
     * 整改状态,字典类型:modify_status_type;1:未整改,2:整改中 ~~~
     */
    private String modifyStatus;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 操作人id
     */
    private String operatorId;

    /**
     * 操作人姓名
     */
    private String operatorName;

    /**
     * 操作时间
     */
    private String operateDate;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo == null ? null : appNo.trim();
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType == null ? null : projectType.trim();
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo == null ? null : companyNo.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getProLeaderName() {
        return proLeaderName;
    }

    public void setProLeaderName(String proLeaderName) {
        this.proLeaderName = proLeaderName == null ? null : proLeaderName.trim();
    }

    public String getProLeaderOaNo() {
        return proLeaderOaNo;
    }

    public void setProLeaderOaNo(String proLeaderOaNo) {
        this.proLeaderOaNo = proLeaderOaNo == null ? null : proLeaderOaNo.trim();
    }

    public String getCityLeaderName() {
        return cityLeaderName;
    }

    public void setCityLeaderName(String cityLeaderName) {
        this.cityLeaderName = cityLeaderName == null ? null : cityLeaderName.trim();
    }

    public String getCityLeaderOaNo() {
        return cityLeaderOaNo;
    }

    public void setCityLeaderOaNo(String cityLeaderOaNo) {
        this.cityLeaderOaNo = cityLeaderOaNo == null ? null : cityLeaderOaNo.trim();
    }

    public BigDecimal getInvestmentPlanAmount() {
        return investmentPlanAmount;
    }

    public void setInvestmentPlanAmount(BigDecimal investmentPlanAmount) {
        this.investmentPlanAmount = investmentPlanAmount;
    }

    public String getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(String planEndTime) {
        this.planEndTime = planEndTime == null ? null : planEndTime.trim();
    }

    public String getProjectYear() {
        return projectYear;
    }

    public void setProjectYear(String projectYear) {
        this.projectYear = projectYear == null ? null : projectYear.trim();
    }

    public String getOperatorTime() {
        return operatorTime;
    }

    public void setOperatorTime(String operatorTime) {
        this.operatorTime = operatorTime == null ? null : operatorTime.trim();
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus == null ? null : projectStatus.trim();
    }

    public String getProcNodeId() {
        return procNodeId;
    }

    public void setProcNodeId(String procNodeId) {
        this.procNodeId = procNodeId == null ? null : procNodeId.trim();
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus == null ? null : checkStatus.trim();
    }

    public String getEngineerType() {
        return engineerType;
    }

    public void setEngineerType(String engineerType) {
        this.engineerType = engineerType == null ? null : engineerType.trim();
    }

    public BigDecimal getEaAmount() {
        return eaAmount;
    }

    public void setEaAmount(BigDecimal eaAmount) {
        this.eaAmount = eaAmount;
    }

    public String getEaTime() {
        return eaTime;
    }

    public void setEaTime(String eaTime) {
        this.eaTime = eaTime == null ? null : eaTime.trim();
    }

    public String getAttorneyId() {
        return attorneyId;
    }

    public void setAttorneyId(String attorneyId) {
        this.attorneyId = attorneyId == null ? null : attorneyId.trim();
    }

    public String getAssignId() {
        return assignId;
    }

    public void setAssignId(String assignId) {
        this.assignId = assignId == null ? null : assignId.trim();
    }

    public String getApprovalCur() {
        return approvalCur;
    }

    public void setApprovalCur(String approvalCur) {
        this.approvalCur = approvalCur == null ? null : approvalCur.trim();
    }

    public BigDecimal getOverRatio() {
        return overRatio;
    }

    public void setOverRatio(BigDecimal overRatio) {
        this.overRatio = overRatio;
    }

    public String getFiId() {
        return fiId;
    }

    public void setFiId(String fiId) {
        this.fiId = fiId == null ? null : fiId.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getAuditProcess() {
        return auditProcess;
    }

    public void setAuditProcess(String auditProcess) {
        this.auditProcess = auditProcess == null ? null : auditProcess.trim();
    }

    public String getProblemNum() {
        return problemNum;
    }

    public void setProblemNum(String problemNum) {
        this.problemNum = problemNum == null ? null : problemNum.trim();
    }

    public String getAudReportNo() {
        return audReportNo;
    }

    public void setAudReportNo(String audReportNo) {
        this.audReportNo = audReportNo == null ? null : audReportNo.trim();
    }

    public String getAudReportCreateTime() {
        return audReportCreateTime;
    }

    public void setAudReportCreateTime(String audReportCreateTime) {
        this.audReportCreateTime = audReportCreateTime == null ? null : audReportCreateTime.trim();
    }

    public String getAuditDayNum() {
        return auditDayNum;
    }

    public void setAuditDayNum(String auditDayNum) {
        this.auditDayNum = auditDayNum == null ? null : auditDayNum.trim();
    }

    public String getAuditMaterialTimeoutFlg() {
        return auditMaterialTimeoutFlg;
    }

    public void setAuditMaterialTimeoutFlg(String auditMaterialTimeoutFlg) {
        this.auditMaterialTimeoutFlg = auditMaterialTimeoutFlg == null ? null : auditMaterialTimeoutFlg.trim();
    }

    public String getAuditMaterialTimeoutNum() {
        return auditMaterialTimeoutNum;
    }

    public void setAuditMaterialTimeoutNum(String auditMaterialTimeoutNum) {
        this.auditMaterialTimeoutNum = auditMaterialTimeoutNum == null ? null : auditMaterialTimeoutNum.trim();
    }

    public String getAuditTimeoutFlg() {
        return auditTimeoutFlg;
    }

    public void setAuditTimeoutFlg(String auditTimeoutFlg) {
        this.auditTimeoutFlg = auditTimeoutFlg == null ? null : auditTimeoutFlg.trim();
    }

    public String getAuditTimeoutNum() {
        return auditTimeoutNum;
    }

    public void setAuditTimeoutNum(String auditTimeoutNum) {
        this.auditTimeoutNum = auditTimeoutNum == null ? null : auditTimeoutNum.trim();
    }

    public String getModifyStatus() {
        return modifyStatus;
    }

    public void setModifyStatus(String modifyStatus) {
        this.modifyStatus = modifyStatus == null ? null : modifyStatus.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate == null ? null : operateDate.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appNo=").append(appNo);
        sb.append(", projectNo=").append(projectNo);
        sb.append(", projectName=").append(projectName);
        sb.append(", projectType=").append(projectType);
        sb.append(", companyNo=").append(companyNo);
        sb.append(", companyName=").append(companyName);
        sb.append(", proLeaderName=").append(proLeaderName);
        sb.append(", proLeaderOaNo=").append(proLeaderOaNo);
        sb.append(", cityLeaderName=").append(cityLeaderName);
        sb.append(", cityLeaderOaNo=").append(cityLeaderOaNo);
        sb.append(", investmentPlanAmount=").append(investmentPlanAmount);
        sb.append(", planEndTime=").append(planEndTime);
        sb.append(", projectYear=").append(projectYear);
        sb.append(", operatorTime=").append(operatorTime);
        sb.append(", projectStatus=").append(projectStatus);
        sb.append(", procNodeId=").append(procNodeId);
        sb.append(", checkStatus=").append(checkStatus);
        sb.append(", engineerType=").append(engineerType);
        sb.append(", eaAmount=").append(eaAmount);
        sb.append(", eaTime=").append(eaTime);
        sb.append(", attorneyId=").append(attorneyId);
        sb.append(", assignId=").append(assignId);
        sb.append(", approvalCur=").append(approvalCur);
        sb.append(", overRatio=").append(overRatio);
        sb.append(", fiId=").append(fiId);
        sb.append(", createTime=").append(createTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", auditProcess=").append(auditProcess);
        sb.append(", problemNum=").append(problemNum);
        sb.append(", audReportNo=").append(audReportNo);
        sb.append(", audReportCreateTime=").append(audReportCreateTime);
        sb.append(", auditDayNum=").append(auditDayNum);
        sb.append(", auditMaterialTimeoutFlg=").append(auditMaterialTimeoutFlg);
        sb.append(", auditMaterialTimeoutNum=").append(auditMaterialTimeoutNum);
        sb.append(", auditTimeoutFlg=").append(auditTimeoutFlg);
        sb.append(", auditTimeoutNum=").append(auditTimeoutNum);
        sb.append(", modifyStatus=").append(modifyStatus);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", operatorName=").append(operatorName);
        sb.append(", operateDate=").append(operateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}