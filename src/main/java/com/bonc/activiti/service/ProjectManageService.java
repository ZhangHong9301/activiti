package com.bonc.activiti.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProjectManageService {

    String importProject(MultipartFile file) throws IOException;

    Object getProject() throws JsonProcessingException;

    String getString(MultipartFile file);

    long getUid();
}
