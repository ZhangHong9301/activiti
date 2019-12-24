package com.bonc.activiti.core.config;

import com.bonc.activiti.core.UUIDGenerator;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-24 16:28
 */
@Configuration
public class MyProcessEngineConfigurator {

    @Autowired
    private UUIDGenerator uuidGenerator;

    @Bean
    public ProcessEngineConfigurationImpl processEngineConfigurationImpl(ProcessEngineConfigurationImpl pro) {
        //设置ProcessEngineConfigurationImpl里的uuidGenerator
        pro.setIdGenerator(uuidGenerator);
        //设置DbSqlSessionFactory的uuidGenerator，否则流程id，任务id，实例id依然是用DbIdGenerator生成
        pro.getDbSqlSessionFactory().setIdGenerator(uuidGenerator);
        return pro;
    }
}
