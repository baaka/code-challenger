package org.code.challenger.model.dto;

import lombok.Data;

@Data
public class UserSubmissionRequestDto {
    private String userName;
    private String input;
    private long taskId;
}
