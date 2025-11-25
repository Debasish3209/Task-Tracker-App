package com.debasish.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debasish.entity.Task;

public interface TaskRepo extends JpaRepository<Task, UUID> {
	List<Task> findByTaskListId(UUID taskListId);

	Optional<Task> findByTaskListIdAndId(UUID taskListId, UUID id);
	void deleteByTaskListIdAndId(UUID taskListId, UUID id);
}
