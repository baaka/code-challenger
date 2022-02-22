package org.code.challenger.client;

import org.code.challenger.model.client.JDoodleExecuteRequestModel;
import org.code.challenger.model.client.JDoodleExecuteResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "jdoodle", url = "https://api.jdoodle.com/v1")
public interface JDoodleClient {

    @PostMapping(path = "/execute", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    JDoodleExecuteResponseModel execute(@RequestBody JDoodleExecuteRequestModel body);
}