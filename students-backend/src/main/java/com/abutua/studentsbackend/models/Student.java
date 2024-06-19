package com.abutua.studentsbackend.models;

public class Student {
  //atributos
  int id;
  String name;
  String email;
  String phone;
  int idCurso;
  int period;

  //metodos construtores
  public Student() {}

  public Student(int id, String name, String email, String phone, int idCurso, int period) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.idCurso = idCurso;
    this.period = period;
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
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public int getIdCurso() {
    return idCurso;
  }
  public void setIdCurso(int idCurso) {
    this.idCurso = idCurso;
  }
  public int getPeriod() {
    return period;
  }
  public void setPeriod(int period) {
    this.period = period;
  }

  

}
