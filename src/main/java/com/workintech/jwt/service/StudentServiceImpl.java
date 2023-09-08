package com.workintech.jwt.service;

import com.workintech.jwt.dao.StudentRepository;
import com.workintech.jwt.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()){
            return student.get();
        }
        return null;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student delete(String tckn) {
        Optional<Student> student = studentRepository.findStudentByTckn(tckn);
        if(student.isPresent()){
            studentRepository.delete(student.get());
            return student.get();
        }
        return null;
    }
}
