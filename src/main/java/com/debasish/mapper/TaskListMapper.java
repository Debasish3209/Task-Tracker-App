package com.debasish.mapper;

import com.debasish.dto.TaskListDto;
import com.debasish.entity.TaskList;

public interface TaskListMapper {

	TaskList fromDto(TaskListDto taskListDto);
	TaskListDto toDto(TaskList taskList);
}
