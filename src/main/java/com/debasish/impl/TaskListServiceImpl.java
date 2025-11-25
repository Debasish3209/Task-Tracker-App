package com.debasish.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.debasish.entity.TaskList;
import com.debasish.repository.TaskListRepo;
import com.debasish.service.TaskListService;

import jakarta.transaction.Transactional;

@Service
public class TaskListServiceImpl implements TaskListService {
	
	private final TaskListRepo taskListRepo;
	
	public TaskListServiceImpl(TaskListRepo taskListRepo) {
		super();
		this.taskListRepo =taskListRepo;
		
	}

	@Override
	public List<TaskList> listTaskList() {
		// TODO Auto-generated method stub
		return taskListRepo.findAll();
	}

	@Override
	public TaskList createTaskList(TaskList taskList) {
		if(null!=taskList.getId()) {
			throw new IllegalArgumentException("Task list already has an id");
		}
		if(null== taskList.getTitle()|| taskList.getTitle().isBlank()) {
			throw new IllegalArgumentException("Task list title must be present");
		}
		LocalDateTime now=LocalDateTime.now();
		
		return taskListRepo.save(new TaskList(
				null,
				taskList.getTitle(),
				taskList.getDescription(),
				null,
				now,
				now));
	}

	@Override
	public Optional<TaskList> getTaskList(UUID id) {
		// TODO Auto-generated method stub
		return taskListRepo.findById(id);
	}

	@Transactional
	@Override
	public TaskList updateTaskList(UUID taskListId, TaskList taskList) {
		// TODO Auto-generated method stub
		if (null== taskList.getId()) {
			throw new IllegalArgumentException("TaskList must have an id");
		}
		if(!Objects.equals(taskList.getId(), taskListId)) {
			throw new IllegalArgumentException("Attempting to change Task List Id, this is not permitted");
		}
		TaskList existingTaskList= taskListRepo.findById(taskListId).orElseThrow(()-> new IllegalArgumentException("OOps Task list not found"));
		existingTaskList.setTitle(taskList.getTitle());
		existingTaskList.setDescription(taskList.getDescription());
		existingTaskList.setUpdated(LocalDateTime.now());
		
		return taskListRepo.save(existingTaskList);
	}

	@Override
	public void deleteTaskList(UUID taskListId) {
		// TODO Auto-generated method stub
		taskListRepo.deleteById(taskListId);
	}

}
