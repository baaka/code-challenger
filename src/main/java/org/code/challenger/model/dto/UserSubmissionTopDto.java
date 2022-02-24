package org.code.challenger.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserSubmissionTopDto {
    private long count;
    private String userName;
    private List<TaskDto> tasks;

    public UserSubmissionTopDto(long count, String userName) {
        this.count = count;
        this.userName = userName;
    }
}
