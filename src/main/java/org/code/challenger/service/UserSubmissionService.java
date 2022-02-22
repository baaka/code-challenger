package org.code.challenger.service;

import org.code.challenger.dto.UserSubmissionDto;
import org.code.challenger.repository.UserSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSubmissionService {

    @Autowired
    private UserSubmissionRepository userSubmissionRepository;

    public UserSubmissionDto addSubmission(UserSubmissionDto userSubmissionDto) {
        return null;
    }

}
