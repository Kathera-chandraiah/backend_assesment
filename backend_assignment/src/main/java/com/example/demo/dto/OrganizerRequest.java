package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrganizerRequest {

	@NotBlank
	private String name;

	@Email
	private String email;

	@NotBlank
	private String phone;

	private String businessType;
}
