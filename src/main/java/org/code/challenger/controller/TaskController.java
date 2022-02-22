package org.code.challenger.controller;

import org.code.challenger.model.dto.TaskDto;
import org.code.challenger.service.TaskService;
import org.code.challenger.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(AppConstants.APP_REST_CONTEXT_PATH + "/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TaskDto> getTasks() {
        return taskService.getTasks();
    }
}
