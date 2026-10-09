package com.example.studenthub.controller;

import com.example.studenthub.entity.Marks;
import com.example.studenthub.service.MarksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marks")
@CrossOrigin(origins = "http://localhost:63342")
public class MarksController {

    private final MarksService marksService;

    public MarksController(MarksService marksService) {
        this.marksService = marksService;
    }

    @PostMapping
    public Marks createMarks(@RequestBody Marks marks) {
        return marksService.createMarks(marks);
    }

    @GetMapping
    public List<Marks> getAllMarks() {
        return marksService.getAllMarks();
    }

    @GetMapping("/{id}")
    public Marks getMarksById(@PathVariable Long id) {
        return marksService.getMarksById(id);
    }

    @PutMapping("/{id}")
    public Marks updateMarks(
            @PathVariable Long id,
            @RequestBody Marks marks) {

        return marksService.updateMarks(id, marks);
    }

    @DeleteMapping("/{id}")
    public void deleteMarks(@PathVariable Long id) {
        marksService.deleteMarks(id);
    }
}