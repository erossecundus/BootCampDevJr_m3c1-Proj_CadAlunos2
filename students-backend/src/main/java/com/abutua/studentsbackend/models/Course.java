package com.abutua.studentsbackend.models;

public class Course {
  //atributos
  int id;
  String name;

  //metodos construtores
  public Course(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public Course() {
  }

  //metodos
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  
}



