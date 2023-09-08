package com.workintech.jwt.service;

import com.workintech.jwt.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(int id);
    Student save(Student student);
    Student delete(String tckn);
}
