package com.example.studenthub.entity;

import jakarta.persistence.*;


//this is entity, test
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String rollNo;
    private String email;
    private String phone;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Student() {
    }

    public Student(String name, String rollNo, String email, String phone, User user) {
        this.name = name;
        this.rollNo = rollNo;
        this.email = email;
        this.phone = phone;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public User getUser() {
        return user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUser(User user) {
        this.user = user;
    }
}