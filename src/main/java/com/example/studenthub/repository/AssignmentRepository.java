package com.example.studenthub.repository;

import com.example.studenthub.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository  extends JpaRepository<Assignment,Long> {
}