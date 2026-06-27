package com.smartcampus.service;

import java.io.PrintWriter;
import java.net.Socket;

public class NotificationClient {

    public static void sendNotification(String message) {

        String host = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(host, port)) {

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            writer.println(message);

            System.out.println("📤 Sent to Notification Service: " + message);

        } catch (Exception e) {
            System.out.println("❌ Failed to send notification: " + e.getMessage());
        }
    }
}