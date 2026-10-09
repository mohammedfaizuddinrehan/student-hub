package com.example.studenthub.service;
import com.example.studenthub.entity.Teacher;
import com.example.studenthub.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TeacherService {

    private final TeacherRepository teacherRepository;
    public TeacherService(TeacherRepository teacherRepository){
    this.teacherRepository=teacherRepository;
    }
    public Teacher createTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }
    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }
    public Teacher getTeacherById(Long id ){
        return teacherRepository.findById(id).orElse(null);

    }
    public Teacher updateTeacher(Long id , Teacher teacher){
        Teacher existingTeacher = teacherRepository.findById(id).orElse(null);
        if (existingTeacher ==null){
            return null;
        }
        existingTeacher.setName(teacher.getName());
        existingTeacher.setEmail(teacher.getEmail());
        existingTeacher.setPhone(teacher.getPhone());
        existingTeacher.setDepartment(teacher.getDepartment());
        return teacherRepository.save(existingTeacher);

    }
    public void deleteTeacher(Long id){
        teacherRepository.deleteById(id);

    }



}
















