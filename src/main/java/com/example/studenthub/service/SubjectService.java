package com.example.studenthub.service;
import com.example.studenthub.entity.Subject;
import com.example.studenthub.entity.Teacher;
import com.example.studenthub.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectService {

private final SubjectRepository subjectRepository;

public SubjectService(SubjectRepository subjectRepository){
    this.subjectRepository=subjectRepository;
}
public Subject createSubject(Subject subject){
    return subjectRepository.save(subject);
}
public List<Subject> getAllSubjects(){
    return subjectRepository.findAll();
}
public Subject getSubjectById(Long id ) {
    return subjectRepository.findById(id).orElse(null);
    }

    public Subject updateSubject(Long id, Subject subject){
    Subject existingSubject =subjectRepository.findById(id).orElse(null);
    if(existingSubject==null){
        return null;
    }

        existingSubject.setName(subject.getName());
        existingSubject.setCode(subject.getCode());
        existingSubject.setCredits(subject.getCredits());
        return subjectRepository.save(existingSubject);
    }

    public void deleteSubject(Long id ){
    subjectRepository.deleteById(id);
    }


}
