package com.abutua.studentsbackend.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.studentsbackend.models.Course;

@RestController
@CrossOrigin
public class CourseController {
  // lista de cursos
  private List<Course> courses = Arrays.asList( new Course(1, "Html/CSS"),
                                                new Course(2, "JavaScript"),
                                                new Course(3, "Java"),
                                                new Course(4, "Angular"),
                                                new Course(5, "Node.js")
  );

  // endpoints
  @GetMapping("courses/{id}")
  public ResponseEntity<Course> getCourse(@PathVariable int id) {
    // cria o stream (lista), acha o primeiro e filtra - ou trata o erro
    Course course = courses.stream()
                            .filter( c -> c.getId() == id)
                            .findFirst()
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
  
    return ResponseEntity.ok(course);
  }

  @GetMapping("courses")
  public List<Course> getCourses() {
    return courses;
  }
  
}
