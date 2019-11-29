package com.bonc.activiti.mapper;

import com.bonc.activiti.entity.AudFinalAccount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface ProjectManageMapper {


    void addProject(List<AudFinalAccount> resultList);

    List<Map<String, Object>> selectProject();
}
