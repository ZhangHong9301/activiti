package com.bonc.activiti.core;

import com.bonc.activiti.uid.impl.CachedUidGenerator;
import com.bonc.activiti.uid.impl.DefaultUidGenerator;
import org.activiti.engine.impl.cfg.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-24 16:31
 */
@Component
public class UUIDGenerator implements IdGenerator {
    @Autowired
    private CachedUidGenerator cachedUidGenerator;
    @Override
    public String getNextId() {
        return String.valueOf(cachedUidGenerator.getUID());
        // return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
