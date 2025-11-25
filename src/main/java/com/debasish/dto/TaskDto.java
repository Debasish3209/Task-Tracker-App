package com.debasish.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.debasish.enums.TaskPriority;
import com.debasish.enums.TaskStatus;
public record TaskDto(
	    UUID id,
	    String title,
	    String description,
	    LocalDateTime dueDate,
	    TaskStatus status,
	    TaskPriority priority
	) {
}
