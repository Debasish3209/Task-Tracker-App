package com.debasish.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.debasish.dto.TaskListDto;
import com.debasish.entity.Task;
import com.debasish.entity.TaskList;
import com.debasish.enums.TaskStatus;
import com.debasish.mapper.TaskListMapper;
import com.debasish.mapper.TaskMapper;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        if (taskListDto == null) {
            return null;
        }

        return new TaskList(
                taskListDto.id(),
                taskListDto.title(),
                taskListDto.description(),
                Optional.ofNullable(taskListDto.tasks())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::fromDto)
                                .toList())
                        .orElse(null),
                null,
                null
        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        if (taskList == null) {
            return null;
        }

        List<Task> tasks = taskList.getTasks();

        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                Optional.ofNullable(tasks).map(List::size).orElse(0),
                calculateTaskListProgress(tasks),
                Optional.ofNullable(tasks)
                        .map(list -> list.stream()
                                .map(taskMapper::toDto) // ✅ FIXED (was todto)
                                .toList())
                        .orElse(null)
        );
    }

    private Double calculateTaskListProgress(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return 0.0;
        }

        long closedTaskCount = tasks.stream()
                .filter(task -> TaskStatus.CLOSED == task.getStatus())
                .count();

        return (double) closedTaskCount / tasks.size();
    }
}
