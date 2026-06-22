package com.smartcampus.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class EnrollmentLoadSimulator {

    // shared mutable state (IMPORTANT for R5)
    private static AtomicInteger successCount = new AtomicInteger(0);

    public static void main(String[] args) {

        // THREAD POOL (R5 requirement)
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // simulate 100 requests
        for (int i = 1; i <= 100; i++) {

            int finalI = i;

            executor.submit(() -> {

                enrollStudent("A100" + (finalI % 5));

            });
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
        }

        System.out.println("DONE!");
        System.out.println("Total successful enrollments: " + successCount.get());
    }

    // shared logic (critical section simulation)
    public static synchronized void enrollStudent(String studentNumber) {

        // simulate processing
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        successCount.incrementAndGet();

        System.out.println("Enrolled: " + studentNumber +
                " | Thread: " + Thread.currentThread().getName());
    }
}