package org.code.challenger.service;

import org.code.challenger.client.JDoodleClient;
import org.code.challenger.model.client.JDoodleExecuteRequestModel;
import org.code.challenger.model.client.JDoodleExecuteResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JDoodleService {

    @Value("${jdoodle.client.id}")
    private String clientId;

    @Value("${jdoodle.client.secret}")
    private String clientSecret;

    @Value("${jdoodle.client.language}")
    private String language;

    @Autowired
    private JDoodleClient jDoodleClient;

    public JDoodleExecuteResponseModel execute(String script) {
        return execute(script, null);
    }

    public JDoodleExecuteResponseModel execute(String script, String inputParam) {
        JDoodleExecuteRequestModel jDoodleExecuteRequestModel = new JDoodleExecuteRequestModel();
        jDoodleExecuteRequestModel.setClientId(clientId);
        jDoodleExecuteRequestModel.setClientSecret(clientSecret);
        jDoodleExecuteRequestModel.setLanguage(language);
        jDoodleExecuteRequestModel.setScript(script);
        jDoodleExecuteRequestModel.setStdin(inputParam);

        return jDoodleClient.execute(jDoodleExecuteRequestModel);
    }
}
