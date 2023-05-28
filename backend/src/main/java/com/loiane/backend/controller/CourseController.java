package com.loiane.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loiane.backend.model.Course;
import com.loiane.backend.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor //Cria o construtor e faz a injeção de dependências
public class CourseController {

    private final CourseRepository courseRepository;

    @GetMapping
    public List<Course> lista() {
        return courseRepository.findAll();
    }
}
