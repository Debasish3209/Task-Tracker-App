package com.debasish.dto;

public record ErrorResponse(
		int status,
		String message,
		String details
		) {

}
