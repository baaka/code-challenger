package org.code.challenger.service;

import org.code.challenger.domain.Task;
import org.code.challenger.domain.UserSubmission;
import org.code.challenger.exception.AppException;
import org.code.challenger.model.dto.UserSubmissionDto;
import org.code.challenger.model.mapper.UserSubmissionMapper;
import org.code.challenger.repository.UserSubmissionRepository;
import org.code.challenger.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserSubmissionService {

    @Autowired
    private UserSubmissionRepository userSubmissionRepository;

    @Autowired
    private TaskService taskService;

    @Autowired
    private JDoodleService jDoodleService;

    public UserSubmissionDto submit(UserSubmissionDto userSubmissionDto) throws AppException {

        validateUserSubmission(userSubmissionDto);

        Task task = taskService.getTaskById(userSubmissionDto.getTaskId());

        String executionResult = jDoodleService.execute(userSubmissionDto.getInput(), task.getInputParameter()).getOutput();
        boolean isSuccess = (task.getOutputParameter().equals(executionResult.trim()));

        UserSubmission userSubmission = new UserSubmission();
        userSubmission.setUserName(userSubmissionDto.getUserName());
        userSubmission.setInput(userSubmissionDto.getInput());
        userSubmission.setResultMessage(executionResult);
        userSubmission.setTask(task);
        userSubmission.setSuccess(isSuccess);

        return addSubmission(userSubmission);
    }

    private UserSubmissionDto addSubmission(UserSubmission userSubmission) {
        return UserSubmissionMapper.toDto(userSubmissionRepository.saveAndFlush(userSubmission));
    }

    private void validateUserSubmission(UserSubmissionDto userSubmissionDto) throws AppException {
        String script = userSubmissionDto.getInput();
        if (script == null || script.trim().isEmpty()) {
            throw new AppException(AppConstants.EXCEPTION_EMPTY_STRING);
        }

        String userName = userSubmissionDto.getUserName();
        if (userName == null || userName.trim().isEmpty()) {
            throw new AppException(AppConstants.EXCEPTION_EMPTY_USERNAME);
        }
    }

}
