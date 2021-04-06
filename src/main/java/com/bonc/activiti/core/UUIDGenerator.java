package com.bonc.activiti.core;

import com.bonc.activiti.uid.impl.CachedUidGenerator;
import com.bonc.activiti.uid.impl.DefaultUidGenerator;
import org.activiti.engine.impl.cfg.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Description:
 * UidGenerator是百度开源的Java语言实现，基于Snowflake算法的唯一ID生成器。
 * 而且，它非常适合虚拟环境，比如：Docker。另外，它通过消费未来时间克服了雪花算法的并发限制。
 * UidGenerator提前生成ID并缓存在RingBuffer中。 压测结果显示，单个实例的QPS能超过6,000,000。
 * 依赖环境：
 * JDK8+
 * MySQL（用于分配WorkerId）
 *
 * snowflake
 * 由下图可知，雪花算法的几个核心组成部分：
 * 1位sign标识位​；
 * 41位时间戳；
 * 10位workId（数据中心+工作机器，可以其他组成方式）；
 * 12位自增序列；
 *
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
