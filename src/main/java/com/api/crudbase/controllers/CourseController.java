package com.api.crudbase.controllers;

import com.api.crudbase.models.Course;
import com.api.crudbase.models.dtos.CourseDto;
import com.api.crudbase.services.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
// test without @crossOrigin
@RequestMapping("/course")
public class CourseController {

    final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@RequestBody @Valid CourseDto courseDto) {
        var course = new Course();
        BeanUtils.copyProperties(courseDto, course);
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(course));
    }
}
