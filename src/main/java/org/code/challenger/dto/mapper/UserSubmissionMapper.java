package org.code.challenger.dto.mapper;

import org.code.challenger.domain.UserSubmission;
import org.code.challenger.dto.TaskDto;
import org.code.challenger.dto.UserSubmissionDto;

public class UserSubmissionMapper {
    public static UserSubmissionDto toDto(UserSubmission userSubmission) {
        UserSubmissionDto userSubmissionDto = new UserSubmissionDto();
        userSubmissionDto.setId(userSubmission.getId());
        userSubmissionDto.setUserName(userSubmission.getUserName());
        userSubmissionDto.setInput(userSubmission.getInput());
        userSubmissionDto.setSuccess(userSubmission.isSuccess());
        userSubmissionDto.setResultMessage(userSubmission.getResultMessage());

        TaskDto taskDto = TaskMapper.toDto(userSubmission.getTask());
        userSubmissionDto.setTask(taskDto);

        return userSubmissionDto;
    }
}
