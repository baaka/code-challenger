package org.code.challenger.model.mapper;

import org.code.challenger.domain.UserSubmission;
import org.code.challenger.model.dto.UserSubmissionDto;

public class UserSubmissionMapper {
    public static UserSubmissionDto toDto(UserSubmission userSubmission) {
        UserSubmissionDto userSubmissionDto = new UserSubmissionDto();
        userSubmissionDto.setId(userSubmission.getId());
        userSubmissionDto.setUserName(userSubmission.getUserName());
        userSubmissionDto.setInput(userSubmission.getInput());
        userSubmissionDto.setSuccess(userSubmission.isSuccess());
        userSubmissionDto.setResultMessage(userSubmission.getResultMessage());
        userSubmissionDto.setTaskId(userSubmission.getTask().getId());

        return userSubmissionDto;
    }
}
