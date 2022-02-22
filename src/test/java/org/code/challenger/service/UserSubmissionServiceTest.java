package org.code.challenger.service;

import org.code.challenger.domain.Task;
import org.code.challenger.exception.AppException;
import org.code.challenger.model.dto.UserSubmissionDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserSubmissionServiceTest {

    @Autowired
    private UserSubmissionService userSubmissionService;

    @Autowired
    private TaskService taskService;

    @Test
    public void submitTest() throws AppException {
        String input = "public class MyClass {public static void main(String args[]) {int x=200; int y=165; int z=x+y; System.out.println(z);}}";
        Task task = taskService.getTaskByName("Simple Sum");

        UserSubmissionDto userSubmissionDto = new UserSubmissionDto();
        userSubmissionDto.setUserName("Baaka");
        userSubmissionDto.setInput(input);
        userSubmissionDto.setTaskId(task.getId());

        UserSubmissionDto result = userSubmissionService.submit(userSubmissionDto);
        Assertions.assertTrue(result.isSuccess());
        Assertions.assertEquals(task.getOutputParameter(), result.getResultMessage().trim());
    }

}
