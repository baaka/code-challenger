package org.code.challenger.service;

import org.code.challenger.domain.Task;
import org.code.challenger.exception.AppException;
import org.code.challenger.model.dto.UserSubmissionRequestDto;
import org.code.challenger.model.dto.UserSubmissionResponseDto;
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

        UserSubmissionRequestDto userSubmissionRequestDto = new UserSubmissionRequestDto();
        userSubmissionRequestDto.setUserName("Baaka");
        userSubmissionRequestDto.setInput(input);
        userSubmissionRequestDto.setTaskId(task.getId());

        UserSubmissionResponseDto result = userSubmissionService.submit(userSubmissionRequestDto);
        Assertions.assertTrue(result.isSuccess());
        Assertions.assertEquals(task.getOutputParameter(), result.getResultMessage().trim());
    }

}
