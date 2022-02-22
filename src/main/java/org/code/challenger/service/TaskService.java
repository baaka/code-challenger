package org.code.challenger.service;

import org.code.challenger.domain.Task;
import org.code.challenger.model.dto.TaskDto;
import org.code.challenger.model.mapper.TaskMapper;
import org.code.challenger.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDto> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return TaskMapper.toDtos(tasks);
    }

    public Task getTaskById(long id) {
        return taskRepository.getById(id);
    }

    public Task getTaskByName(String name) {
        return taskRepository.getByName(name);
    }

}
