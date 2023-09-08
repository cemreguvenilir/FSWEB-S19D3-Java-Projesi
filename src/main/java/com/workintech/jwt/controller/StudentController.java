package com.workintech.jwt.controller;

import com.workintech.jwt.entity.Student;
import com.workintech.jwt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id){
        return studentService.findById(id);
    }

    @PostMapping("/")
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable int id, @RequestBody Student student){
        Student student1 = getById(id);
        if(student1 != null){
            student.setId(id);
            return studentService.save(student);
        }
        return null;
    }

    @DeleteMapping("/{tckn}")
    public Student delete(@PathVariable String tckn){
            return studentService.delete(tckn);
    }
}
