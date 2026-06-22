package com.smartcampus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartcampus.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}