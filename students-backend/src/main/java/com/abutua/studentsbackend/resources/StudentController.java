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
@CrossOrigin
public class StudentController {
  
  //lista de alunos
  private List<Student> students = Arrays.asList(
    new Student(1, "Ana Antônia", "nome1@email.com", "(15) 99999-9999", 1, 2),
    new Student(2, "Beto Balanço", "nome2@email.com", "(15) 99999-9999", 2, 1),
    new Student(3, "Calros Cunha", "nome3@email.com", "(15) 99999-9999", 3, 3),
    new Student(3, "Diana Dione", "nome4@email.com", "(15) 99999-9999", 4, 2)
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
