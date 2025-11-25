package com.debasish.mapper;

import com.debasish.dto.TaskDto;
import com.debasish.entity.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);
    TaskDto toDto(Task task);
}

