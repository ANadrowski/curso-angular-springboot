package com.loiane.backend.dto.mapper;

import org.springframework.stereotype.Component;

import com.loiane.backend.dto.CourseDTO;
import com.loiane.backend.enums.Category;
import com.loiane.backend.model.Course;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course) {
        if (course == null) {
            return null;
        }
        return new CourseDTO(course.getId(), course.getName(), "Front-end");
    }

    public Course toEntity(CourseDTO courseDTO) {
        if (courseDTO == null) {
            return null;
        }
        
        Course course = new Course();

        if (courseDTO.id() != null) {
            course.setId(courseDTO.id());
        }
        course.setName(courseDTO.name());
        course.setCategory(Category.FRONT_END);
        //Aqui não precisa setar o status, pois cada novo objeto já é setado como Ativo.
        return course;
    }
    
}
