package com.debasish.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debasish.entity.TaskList;

public interface TaskListRepo extends JpaRepository<TaskList, UUID> {

}
