package com.debasish.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.debasish.entity.Task;
import com.debasish.entity.TaskList;
import com.debasish.enums.TaskPriority;
import com.debasish.enums.TaskStatus;
import com.debasish.repository.TaskListRepo;
import com.debasish.repository.TaskRepo;
import com.debasish.service.TaskService;

import jakarta.transaction.Transactional;

@Service
public class TaskServiceImpl implements TaskService {

	private final TaskRepo taskRepo;
	private final TaskListRepo taskListRepo;
	
	public TaskServiceImpl(TaskRepo taskRepo, TaskListRepo taskListRepo) {
		super();
		this.taskRepo=taskRepo;
		this.taskListRepo=taskListRepo;
	}
	
	@Override
	public List<Task> listTasks(UUID taskListId) {
		// TODO Auto-generated method stub
		return taskRepo.findByTaskListId(taskListId);
	}

    @Override
    public Task createTask(UUID taskListId, Task task) {
        if (task.getId() != null) {
            throw new IllegalArgumentException("Task already has an ID!");
        }
        if (task.getTitle() == null || task.getTitle().isBlank()) {
            throw new IllegalArgumentException("Task must have a title!");
        }

        // Default values
        TaskPriority priority = Optional.ofNullable(task.getPriority()).orElse(TaskPriority.MEDIUM);
        TaskStatus status = Optional.ofNullable(task.getStatus()).orElse(TaskStatus.OPEN);

        // Verify TaskList exists
        TaskList taskList = taskListRepo.findById(taskListId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid TaskList ID provided"));

        LocalDateTime now = LocalDateTime.now();

        Task taskToSave = new Task(
                null,
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                status,
                priority,
                taskList,
                now,
                now
        );

        return taskRepo.save(taskToSave);
    }

	@Override
	public Optional<Task> getTask(UUID taskListId, UUID taskId) {
		return taskRepo.findByTaskListIdAndId(taskListId, taskId);
	}

	@Override
	public Task updateTask(UUID taskListId, UUID taskId, Task task) {
		// TODO Auto-generated method stub
		if(null==task.getId()) {
			throw new IllegalArgumentException("Task must have an id");
		}
		if(!Objects.equals(taskId, task.getId())) {
			throw new IllegalArgumentException("Task id do not match");
		}
		if(null== task.getPriority()) {
			throw new IllegalArgumentException("Task must have a valid priority");
		}
		if(null== task.getStatus()) {
			throw new IllegalArgumentException("Task must have a valid status");
		}
		Task existingTask=taskRepo.findByTaskListIdAndId(taskListId, taskId)
				.orElseThrow(()-> new IllegalArgumentException("Task not found"));
		existingTask.setTitle(task.getTitle());
		existingTask.setDescription(task.getDescription());
		existingTask.setDueDate(task.getDueDate());
		existingTask.setPriority(task.getPriority());
		existingTask.setStatus(task.getStatus());
		existingTask.setUpdated(LocalDateTime.now());
		
		return taskRepo.save(existingTask);
	}

	@Transactional
	@Override
	public void deleteTask(UUID taskListId, UUID taskId) {
		// TODO Auto-generated method stub
		taskRepo.deleteByTaskListIdAndId(taskListId, taskId);
	}

}
