package com.smartcampus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.smartcampus.entity.Enrollment;
import com.smartcampus.repository.EnrollmentRepository;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository repo;

    @Autowired
    private RestTemplate restTemplate;

    // =========================
    // R4: CALL STUDENT SERVICE
    // =========================
    public boolean checkStudentExists(String studentNumber) {

        String url = "http://localhost:8081/students";

        try {
            System.out.println("📡 CALLING STUDENT SERVICE...");

            Object[] students =
                restTemplate.getForObject(url, Object[].class);

            if (students == null) {
                System.out.println("❌ NULL RESPONSE");
                return false;
            }

            for (Object s : students) {
                if (s.toString().contains(studentNumber)) {
                    System.out.println("✅ STUDENT FOUND");
                    return true;
                }
            }

            System.out.println("❌ STUDENT NOT FOUND");
            return false;

        } catch (Exception e) {

            System.out.println("⚠ STUDENT SERVICE DOWN!");

            // R9: FAILURE HANDLING (graceful)
            // IMPORTANT: do NOT crash API
            return false;
        }
    }

    // =========================
    // CREATE ENROLMENT (R4 + R6)
    // =========================
    public ResponseEntity<?> save(Enrollment e) {

        System.out.println("🔵 START ENROLMENT PROCESS");

        boolean exists = checkStudentExists(e.getStudentNumber());

        System.out.println("🟡 STUDENT EXISTS? = " + exists);

        // =========================
        // VALIDATION FAIL
        // =========================
        if (!exists) {
            System.out.println("❌ BLOCKED - INVALID STUDENT");

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Student not found or Student Service unavailable");
        }

        // =========================
        // SAVE TO DB
        // =========================
        Enrollment saved = repo.save(e);

        System.out.println("💾 ENROLMENT SAVED");

        // =========================
        // R6 - NOTIFICATION (TCP)
        // =========================
        try {
            NotificationClient.sendNotification(
                "Student enrolled successfully: " + e.getStudentNumber()
            );
        } catch (Exception ex) {
            System.out.println("⚠ Notification failed but enrolment still saved");
        }

        System.out.println("🟢 ENROLMENT COMPLETE");

        return ResponseEntity.ok(saved);
    }

    // =========================
    // GET ALL
    // =========================
    public List<Enrollment> getAll() {
        return repo.findAll();
    }
}