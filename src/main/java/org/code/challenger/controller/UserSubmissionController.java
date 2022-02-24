package org.code.challenger.controller;

import org.code.challenger.exception.AppException;
import org.code.challenger.model.dto.UserSubmissionRequestDto;
import org.code.challenger.model.dto.UserSubmissionResponseDto;
import org.code.challenger.model.dto.UserSubmissionTopDto;
import org.code.challenger.service.UserSubmissionService;
import org.code.challenger.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppConstants.APP_REST_CONTEXT_PATH + "/submission")
public class UserSubmissionController {

    @Autowired
    private UserSubmissionService userSubmissionService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserSubmissionResponseDto submit(@RequestBody UserSubmissionRequestDto userSubmissionRequestDto) throws AppException {
        return userSubmissionService.submit(userSubmissionRequestDto);
    }

    @GetMapping(path = "/top", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserSubmissionTopDto> getTopSuccessfulSubmitters() {
        return userSubmissionService.getTopSuccessfulSubmitters(3);
    }
}
