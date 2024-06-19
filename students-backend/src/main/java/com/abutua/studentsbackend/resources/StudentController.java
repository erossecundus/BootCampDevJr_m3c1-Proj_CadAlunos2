package com.abutua.studentsbackend.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.studentsbackend.models.Student;


@RestController
//@CrossOrigin
public class StudentController {
  
  //lista de alunos
  private List<Student> students = Arrays.asList(
    new Student(1, "Nome Primeiro", "nome1@email.com", "(15) 99999-9999", 1, 2),
    new Student(2, "Nome Segundo", "nome2@email.com", "(15) 99999-9999", 2, 4),
    new Student(3, "Nome Terceiro", "nome3@email.com", "(15) 99999-9999", 3, 6)
  );

  //endpoints
  @GetMapping("students/{id}")
  public ResponseEntity<Student> getStudent(@PathVariable int id) {
    
    // ..forma tradicional de verificar a validade..
    // if( id <= students.size()) { 
    //   return ResponseEntity.ok(students.get(id-1));
    //   }
    //   else {
    //   throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Student not found");
    //   }

    //cria o stream (lista), acha o primeiro e filtra - ou trata o erro
    Student stud = students.stream()
                            .filter( s -> s.getId() == id)
                            .findFirst()
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
  
    return ResponseEntity.ok(stud);
  }


  @GetMapping("students")
  public List<Student> getStudents() {
    return students;
  }
}
