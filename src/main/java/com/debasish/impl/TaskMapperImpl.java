package com.debasish.impl;

import org.springframework.stereotype.Component;

import com.debasish.dto.TaskDto;
import com.debasish.entity.Task;
import com.debasish.mapper.TaskMapper;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task fromDto(TaskDto taskDto) {
        if (taskDto == null) {
            return null;
        }

        return Task.builder()
                .id(taskDto.id())
                .title(taskDto.title())
                .description(taskDto.description())
                .dueDate(taskDto.dueDate())
                .status(taskDto.status())
                .priority(taskDto.priority())
                .build();
    }

    @Override
    public TaskDto toDto(Task task) {   // ✅ renamed to match interface & controller
        if (task == null) {
            return null;
        }

        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getStatus(),
                task.getPriority()
        );
    }
}
