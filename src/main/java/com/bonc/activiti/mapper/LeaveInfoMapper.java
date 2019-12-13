package com.bonc.activiti.mapper;

import com.bonc.activiti.entity.LeaveInfo;
import com.bonc.activiti.entity.LeaveConverter;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: ZhangHong
 * @Date: 2019-12-06 16:43
 */

@Repository
public interface LeaveInfoMapper {

    void addLeaveInfo(LeaveInfo leaveInfo);

    LeaveConverter getLeaveInfo(String id);
}
