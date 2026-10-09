package com.example.studenthub.controller;

import com.example.studenthub.dto.CreateStudentRequest;
import com.example.studenthub.entity.Student;
import com.example.studenthub.repository.StudentRepository;
import com.example.studenthub.service.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final StudentRepository studentRepository;

    public StudentController(StudentService studentService, StudentRepository studentRepository){
    this.studentService = studentService;
        this.studentRepository = studentRepository;
    }
    @PostMapping
    public Student createStudent(@RequestBody CreateStudentRequest request) {
        return studentService.createStudent(request);
    }
@GetMapping
    public List <Student> getAllStudents() {
    return studentService.getAllStudents();
}
  @GetMapping("/{id}")

    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
    @PutMapping("/{id}")

    public Student updateStudent(@PathVariable Long id ,@RequestBody Student student){
        return studentService.updateStudent(id,student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }



}
