package com.example.studenthub.entity;

import jakarta.persistence.*;

@Entity
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double marks;
    private String exam;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Marks() {
    }

    public Marks(double marks, String exam, Student student, Subject subject) {
        this.marks = marks;
        this.exam = exam;
        this.student = student;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public double getMarks() {
        return marks;
    }

    public String getExam() {
        return exam;
    }

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setSubject(Subject subject) {

        this.subject = subject;
    }
}