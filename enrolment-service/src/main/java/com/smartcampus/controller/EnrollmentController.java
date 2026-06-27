package com.smartcampus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smartcampus.entity.Enrollment;
import com.smartcampus.service.EnrollmentService;

@RestController
@RequestMapping("/enrolments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService service;

    @GetMapping
    public List<Enrollment> getAll() {
        return service.getAll();
    }

    // 🔥 FIX HERE (IMPORTANT)
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Enrollment e) {
        return service.save(e);
    }
}