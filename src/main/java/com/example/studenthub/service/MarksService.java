package com.example.studenthub.service;
import com.example.studenthub.entity.Marks;
import com.example.studenthub.repository.MarksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarksService {

    private final MarksRepository marksRepository;

    public MarksService (MarksRepository marksRepository){
        this.marksRepository=marksRepository;
    }

    public Marks createMarks(Marks marks){
        return marksRepository.save(marks);
    }
    public List<Marks> getAllMarks(){
        return marksRepository.findAll();
    }
    public Marks getMarksById(Long id){
        return marksRepository.findById(id).orElse(null);
    }

    public Marks updateMarks(Long id , Marks marks){
    Marks existingMarks = marksRepository.findById(id).orElse(null);
    if (existingMarks==null){
        return null;
    }
        existingMarks.setMarks(marks.getMarks());
        existingMarks.setExam(marks.getExam());
        existingMarks.setStudent(marks.getStudent());
        existingMarks.setSubject(marks.getSubject());
        return marksRepository.save(existingMarks);

    }

    public void deleteMarks(long id ) {
        marksRepository.deleteById(id);
    }
}
