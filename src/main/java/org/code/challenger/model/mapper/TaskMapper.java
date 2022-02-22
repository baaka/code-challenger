package org.code.challenger.model.mapper;

import org.code.challenger.domain.Task;
import org.code.challenger.model.dto.TaskDto;

import java.util.ArrayList;
import java.util.List;

public class TaskMapper {
    public static TaskDto toDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setName(task.getName());
        taskDto.setDescription(task.getDescription());
        return taskDto;
    }

    public static List<TaskDto> toDtos(List<Task> tasks) {
        List<TaskDto> result = new ArrayList<>();
        if (tasks != null && !tasks.isEmpty()) {
            for (Task task : tasks) {
                result.add(toDto(task));
            }
        }
        return result;
    }
}
