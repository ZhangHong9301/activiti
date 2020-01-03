package com.bonc.activiti.uid.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-31 16:01
 */
@Configuration
@ImportResource(locations = {"classpath:cached-uid-spring.xml"})
public class UidConfig {
}
