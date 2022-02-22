package org.code.challenger.service;

import org.code.challenger.domain.Task;
import org.code.challenger.dto.TaskDto;
import org.code.challenger.dto.mapper.TaskMapper;
import org.code.challenger.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDto> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return TaskMapper.toDtos(tasks);
    }
}
