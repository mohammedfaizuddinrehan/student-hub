package com.example.studenthub.controller;
import com.example.studenthub.entity.Teacher;
import com.example.studenthub.service.TeacherService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/teachers")
@CrossOrigin(origins="http://localhost:63342")

public class TeacherController {
    private final TeacherService teacherService;
    public TeacherController(TeacherService teacherService){
        this.teacherService=teacherService;
    }
    @PostMapping
    public Teacher CreateTeacher(@RequestBody Teacher teacher){
        return teacherService.createTeacher(teacher);
    }

    @GetMapping
    public List<Teacher> getAllTeacher(){
        return teacherService.getAllTeachers();
    }
    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Long id){
        return teacherService.getTeacherById(id);
    }
    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Long id,
                                 @RequestBody Teacher teacher){
        return teacherService.updateTeacher(id,teacher);

    }



    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacher(id);








    }
}
