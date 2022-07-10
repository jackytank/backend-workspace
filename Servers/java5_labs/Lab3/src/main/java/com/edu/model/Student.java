package com.edu.model;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@NotBlank(message = "{NotBlank.student.name}")
	private String name;
	@NotBlank(message = "Please enter email address!!")
	@Email(message = "{Email.student.email}")
	private String email;
	@Min(message = "Mark must be above 0", value = 0)
	@Max(message = "Mark must be below 10", value = 10)
	@NotNull(message = "Please enter mark!!")
	private Double mark;
	@NotNull(message = "Please choose gender!!")
	private Boolean gender;
	@NotBlank(message = "Please choose faculty!!")
	private String faculty;
	@NotEmpty(message = "Please choose hobby!!")
	private List<String> hobby;

	private MultipartFile imageFile;
	private String imageUrl;
}
