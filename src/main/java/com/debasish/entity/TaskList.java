package com.debasish.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class TaskList {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id" , updatable = false, nullable = false)
	private UUID id;
	
	@Column(name = "title" ,nullable = false)
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "taskList" , cascade = {CascadeType.REMOVE , CascadeType.PERSIST})
	private List<Task>tasks;
	
	@Column(name = "created" , nullable = false)
	private LocalDateTime created;
	
	@Column(name = "updated" , nullable = false)
	private LocalDateTime updated;
}
