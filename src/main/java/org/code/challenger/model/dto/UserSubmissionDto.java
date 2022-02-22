package org.code.challenger.model.dto;

import lombok.Data;

@Data
public class UserSubmissionDto {
    private long id;
    private String userName;
    private String input;
    private boolean success;
    private String resultMessage;
    private long taskId;
}
