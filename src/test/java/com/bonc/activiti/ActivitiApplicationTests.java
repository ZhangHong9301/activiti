package com.bonc.activiti;

import com.bonc.activiti.uid.UidGenerator;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.regex.Pattern;

@SpringBootTest(classes = ActivitiApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
class ActivitiApplicationTests {

    @Autowired
    private UidGenerator uidGenerator;

    @Test
    public void getUid() {
        System.out.println(uidGenerator.getUID());
    }

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        boolean matches = Pattern.matches("^[2-9]\\d{3}$", "2019");
        System.out.println(matches);
    }


}
