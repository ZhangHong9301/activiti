package com.bonc.activiti.core;

import org.activiti.engine.impl.cfg.IdGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-24 16:31
 */
@Component
public class UUIDGenerator implements IdGenerator {

    @Override
    public String getNextId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
