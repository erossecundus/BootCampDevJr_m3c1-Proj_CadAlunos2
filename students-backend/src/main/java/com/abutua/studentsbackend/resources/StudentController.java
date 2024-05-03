package com.abutua.studentsbackend.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.abutua.studentsbackend.models.Student;

@RestController
@CrossOrigin
public class StudentController {
  
  //lista de alunos
  private List<Student> students = new ArrayList();


  //endpoints
}
