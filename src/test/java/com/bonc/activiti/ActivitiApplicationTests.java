package com.bonc.activiti;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Pattern;

@SpringBootTest
class ActivitiApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        boolean matches = Pattern.matches("^[2-9]\\d{3}$", "2019");
        System.out.println(matches);
    }


}
