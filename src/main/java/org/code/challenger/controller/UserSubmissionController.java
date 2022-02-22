package org.code.challenger.controller;

import org.code.challenger.exception.AppException;
import org.code.challenger.model.dto.UserSubmissionDto;
import org.code.challenger.service.UserSubmissionService;
import org.code.challenger.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AppConstants.APP_REST_CONTEXT_PATH + "/submission")
public class UserSubmissionController {

    @Autowired
    private UserSubmissionService userSubmissionService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void submit(@RequestBody UserSubmissionDto userSubmissionDto) throws AppException {
        userSubmissionService.submit(userSubmissionDto);
    }
}
