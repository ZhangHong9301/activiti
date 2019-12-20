##################################################
/*
Deployment 部署对象
一次部署的多个文件的信息。对于不需要的流程可以删除和修改。
相关表：
act_re_deployment 部署对象表
act_re_procdef 流程定义表
act_ge_bytearray 资源文件表
act_ge_property 主键生成策略表

ProcessDefinition 流程定义
解析.bpmn后得到的流程定义规则的信息，工作流系统就是按照流程定义的规则执行的。
相关表：
act_re_deployment 部署对象表
act_re_procdef 流程定义表
act_ge_bytearray 资源文件表
act_ge_property 主键生成策略表

ProcessInstance 流程实例
特指流程从开始到结束的那个最大的执行分支，一个执行的流程中，
流程实例只有1个。
注：
1. 如果是单例流程，执行对象ID就是流程实例ID
2. 如果一个流程有分支和聚合，那么执行对象ID和流程实例ID就不相同
3. 一个流程中，流程实例只有1个，执行对象可以存在多个。

Execution 执行对象
按流程定义的规则执行一次的过程。
对应的表：
act_ru_execution 正在执行的信息
act_hi_procinst 已经执行完的历史流程实例信息
act_hi_actinst 存放历史所有完成的活动

Task 任务
执行到某任务环节时生成的任务信息。
对应的表：
act_ru_task 正在执行的任务信息
act_hi_taskinst 已经执行完的历史任务信息

流程变量
作用：
1. 用来传递业务参数
2. 指定连线完成任务（同意和拒绝）
3. 动态指定任务的办理人
其作用域只对应一个流程实例，也就是说各个流程实例的流程变量
是互不影响的，流程实例结束完成以后流程变量还保存在数据库中。
关于流程变量类型说明：
流程变量类型除了基本类型还有Serializable,用Javabean类型设置流程变量时，需要这个Javabean实现Serializable接口

总结

分配个人任务三种方式
  *直接给值，在xxx.bpmn文件中指定
  *流程变量${流程变量名称}或者#{}
  *使用类监听这个类（实现一个接口），指定任务的办理人（setAssgnee()）

个人任务与组任务
  *都是用TaskService完成
  *个人任务(taskAssgnee),组任务(taskCandidateUser)


*/
######################################################


## 部署对象和流程定义相关表
# 部署信息表
SELECT *
FROM act_re_deployment;

# 流程设计模型部署表
SELECT *
FROM act_re_model;

# 流程定义表
SELECT *
FROM act_re_procdef;

# 资源文件表
SELECT *
FROM act_ge_bytearray;

SELECT *
FROM act_ge_property;

###################################################
## 流程实例、执行对象、任务相关表
# 历史流程实例表
SELECT *
FROM act_hi_procinst;

# 运行时执行对象表
SELECT *
FROM act_ru_execution;

# 运行时任务表   
SELECT *
FROM act_ru_task;

SELECT *
FROM ACT_RU_IDENTITYLINK;

# 历史任务实例表
SELECT *
FROM act_hi_taskinst;

SELECT *
FROM ACT_HI_IDENTITYLINK;


###################################################
## 流程变量
# 运行时流程变量表
SELECT *
FROM act_ru_variable;

# 历史流程变量表
SELECT *
FROM act_hi_varinst;

###################################################
## 组织机构表
# 用户组表
SELECT *
FROM act_id_group;
# 用户扩展表
SELECT *
FROM act_id_info;
# 用户与用户组对应表
SELECT *
FROM act_id_membership;
# 用户表
SELECT *
FROM act_id_user;

# 历史所有活动节点表
SELECT *
FROM act_hi_actinst;

# 待办任务查询
# 表：ACT_RU_TASK
# ACT_RU_IDENTITYLINK
# Parameters: 部门经理(String), 10(Integer), 0(Integer)
SELECT DISTINCT RES.*
FROM ACT_RU_TASK RES INNER JOIN ACT_RU_IDENTITYLINK I ON I.TASK_ID_ = RES.ID_
WHERE RES.ASSIGNEE_ IS NULL AND I.TYPE_ = 'candidate' AND (I.GROUP_ID_ IN ('人事'))
ORDER BY RES.ID_ ASC
LIMIT 10 OFFSET 0;

# 历史任务实例查询
SET @userId = '蛮大人';
SELECT DISTINCT RES.*
FROM ACT_HI_TASKINST RES
WHERE RES.END_TIME_ IS NOT NULL AND (exists(SELECT LINK.USER_ID_
                                            FROM ACT_HI_IDENTITYLINK LINK
                                            WHERE USER_ID_ = @userId AND LINK.TASK_ID_ = RES.ID_) OR
                                     RES.ASSIGNEE_ = @userId OR
                                     RES.OWNER_ = @user)
ORDER BY RES.ID_ ASC
LIMIT 10 OFFSET 0

# 流程追踪



