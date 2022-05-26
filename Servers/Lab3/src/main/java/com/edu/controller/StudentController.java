package com.edu.controller;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.model.Student;

@Controller
@RequestMapping("student")
public class StudentController {
	@Autowired
	ServletContext app;

	@GetMapping("form")
	public String form(ModelMap model) {
		Student student = new Student("Your name...", "YourEmail@domain.com", 0d, true, null, null, null, null);
		model.addAttribute("student", student);
		return "student/form";
	}

	@PostMapping("save")
	public String save(ModelMap model, @Validated @ModelAttribute("student") Student student, Errors err) {
		if (!student.getImageFile().isEmpty()) {
			try {
				String fileName = student.getImageFile().getOriginalFilename();
				File file = new File(app.getRealPath("/resources/" + fileName));
				System.out.println(file.getAbsolutePath());
				student.getImageFile().transferTo(file);
				student.setImageUrl("/resources/" + fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (err.hasErrors()) {
			model.addAttribute("message", "Please fix all errors!!");
			return "student/form";
		} else {
			model.addAttribute("message", "Hurray! You've successfully save!");
		}
		return "student/detail";
	}

	@ModelAttribute("genders")
	public Map<Boolean, String> getGenders() {
		Map<Boolean, String> map = new HashMap<>();
		map.put(true, "Male");
		map.put(false, "Female");
		return map;
	}

	@ModelAttribute("faculties")
	public List<String> getFaculties() {
		return Arrays.asList("CNTT", "QHCH", "QTDN");
	}

	@ModelAttribute("hobbies")
	public Map<String, String> getHobbies() {
		Map<String, String> map = new HashMap<>();
		map.put("M", "Music");
		map.put("G", "Gaming");
		map.put("H", "Hiking");
		map.put("P", "Picnic");
		return map;
	}
}
