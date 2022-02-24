package org.code.challenger.service;

import org.code.challenger.domain.Task;
import org.code.challenger.domain.UserSubmission;
import org.code.challenger.exception.AppException;
import org.code.challenger.model.dto.UserSubmissionRequestDto;
import org.code.challenger.model.dto.UserSubmissionResponseDto;
import org.code.challenger.model.dto.UserSubmissionTopDto;
import org.code.challenger.model.mapper.TaskMapper;
import org.code.challenger.model.mapper.UserSubmissionMapper;
import org.code.challenger.repository.UserSubmissionRepository;
import org.code.challenger.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserSubmissionService {

    @Autowired
    private UserSubmissionRepository userSubmissionRepository;

    @Autowired
    private TaskService taskService;

    @Autowired
    private JDoodleService jDoodleService;

    public UserSubmissionResponseDto submit(UserSubmissionRequestDto userSubmissionRequestDto) throws AppException {

        validateUserSubmission(userSubmissionRequestDto);

        Task task = taskService.getTaskById(userSubmissionRequestDto.getTaskId());

        String executionResult = jDoodleService.execute(userSubmissionRequestDto.getInput(), task.getInputParameter()).getOutput();
        boolean isSuccess = (task.getOutputParameter().equals(executionResult.trim()));

        UserSubmission userSubmission = new UserSubmission();
        userSubmission.setUserName(userSubmissionRequestDto.getUserName());
        userSubmission.setInput(userSubmissionRequestDto.getInput());
        userSubmission.setResultMessage(executionResult);
        userSubmission.setTask(task);
        userSubmission.setSuccess(isSuccess);

        return addSubmission(userSubmission);
    }

    public List<UserSubmissionTopDto> getTopSuccessfulSubmitters(int top) {
        List<UserSubmissionTopDto> result = userSubmissionRepository.findTopSuccessfulSubmissionsWithPagination(PageRequest.of(0, top)).getContent();
        for (UserSubmissionTopDto usdto : result) {
            String userName = usdto.getUserName();
            List<Task> userTasks = userSubmissionRepository.findAllByUserNameAndSuccess(userName, true).stream().map(UserSubmission::getTask).toList();
            usdto.setTasks(TaskMapper.toDtos(userTasks));
        }

        return result;
    }

    private UserSubmissionResponseDto addSubmission(UserSubmission userSubmission) {

        if (userSubmission.isSuccess()) {
            UserSubmission found = userSubmissionRepository.findByUserNameAndSuccessAndTaskId(userSubmission.getUserName(), true, userSubmission.getTask().getId());
            if (found != null) {
                userSubmission.setId(found.getId());
            }
        }

        return UserSubmissionMapper.toDto(userSubmissionRepository.saveAndFlush(userSubmission));
    }

    private void validateUserSubmission(UserSubmissionRequestDto userSubmissionRequestDto) throws AppException {
        String script = userSubmissionRequestDto.getInput();
        if (script == null || script.trim().isEmpty()) {
            throw new AppException(AppConstants.EXCEPTION_EMPTY_STRING);
        }

        String userName = userSubmissionRequestDto.getUserName();
        if (userName == null || userName.trim().isEmpty()) {
            throw new AppException(AppConstants.EXCEPTION_EMPTY_USERNAME);
        }
    }

}
