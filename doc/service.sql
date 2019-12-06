# 部署信息表
SELECT *
FROM act_re_deployment;

# 流程设计模型部署表
SELECT *
FROM act_re_model;

# 流程定义数据表
SELECT *
FROM act_re_procdef;

SELECT *
FROM act_ge_bytearray;

SELECT *
FROM act_ge_property;

### 运行时数据库表
# 运行时流程执行实例表
SELECT *
FROM act_ru_execution;
# 运行时流程人员表
SELECT * from act_ru_identitylink;
# 运行时任务节点表   
SELECT *
FROM act_ru_task;
# 运行时流程变量数据表
SELECT *
FROM act_ru_variable;

### 组织机构表
# 用户组信息表
SELECT * from act_id_group;
# 用户扩展信息表
SELECT * from act_id_info;
# 用户与用户组对应信息表
SELECT * from act_id_membership; 
# 用户信息表
SELECT * from act_id_user;

SELECT *
FROM aud_leave_info;