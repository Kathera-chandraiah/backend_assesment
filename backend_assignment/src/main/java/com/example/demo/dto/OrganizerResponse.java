package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizerResponse {
	private String name;

	private String email;

	private String phone;

	private String businessType;

	private String organizerCode;

}
