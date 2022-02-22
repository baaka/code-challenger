package org.code.challenger.model.client;

import lombok.Data;

@Data
public class JDoodleExecuteResponseModel {
    private String output;
    private int statusCode;
    private String memory;
    private String cpuTime;
}
