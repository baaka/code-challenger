package org.code.challenger.service;

import org.code.challenger.model.client.JDoodleExecuteResponseModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JDoodleServiceTest {

    @Autowired
    private JDoodleService jDoodleService;

    @Test
    public void executeTest() {
        String script = "public class MyClass {public static void main(String args[]) {int x=200; int y=165; int z=x+y; System.out.println(z);}}";

        JDoodleExecuteResponseModel rm = jDoodleService.execute(script);
        Assertions.assertEquals("365", rm.getOutput().trim());
    }
}
