package org.code.challenger.model.mapper;

import org.code.challenger.domain.UserSubmission;
import org.code.challenger.model.dto.UserSubmissionResponseDto;

public class UserSubmissionMapper {
    public static UserSubmissionResponseDto toDto(UserSubmission userSubmission) {
        UserSubmissionResponseDto userSubmissionDto = new UserSubmissionResponseDto();
        userSubmissionDto.setUserName(userSubmission.getUserName());
        userSubmissionDto.setInput(userSubmission.getInput());
        userSubmissionDto.setSuccess(userSubmission.isSuccess());
        userSubmissionDto.setResultMessage(userSubmission.getResultMessage());
        userSubmissionDto.setTaskId(userSubmission.getTask().getId());

        return userSubmissionDto;
    }
}
