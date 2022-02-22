package org.code.challenger.model.client;

import lombok.Data;

@Data
public class JDoodleExecuteRequestModel {
    private String clientId;
    private String clientSecret;
    private String script;
    private String stdin;
    private String language;
}
