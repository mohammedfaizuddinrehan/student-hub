package com.example.studenthub.service;
import com.example.studenthub.dto.CreateStudentRequest;
import com.example.studenthub.entity.User;
import com.example.studenthub.entity.Student;
import com.example.studenthub.repository.StudentRepository;
import org.springframework.stereotype.Service;
import com.example.studenthub.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public StudentService(
            StudentRepository studentRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Student createStudent(CreateStudentRequest request) {

        User user = new User();

        user.setEmail(request.getEmail());

        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        user.setRole("STUDENT");
        user = userRepository.save(user);
        Student student = new Student();

        student.setName(request.getName());
        student.setRollNo(request.getRollNo());
        student.setEmail(request.getEmail());
        student.setPhone(request.getPhone());
        student.setUser(user);
        student = studentRepository.save(student);

        return student;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student student) {

        Student existingStudent =
                studentRepository.findById(id).orElse(null);

        if (existingStudent == null) {
            return null;
        }

        existingStudent.setName(student.getName());
        existingStudent.setRollNo(student.getRollNo());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPhone(student.getPhone());

        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}