package com.smartcampus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartcampus.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}