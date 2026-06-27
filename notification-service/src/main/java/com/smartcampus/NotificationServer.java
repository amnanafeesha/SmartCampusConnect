package com.smartcampus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class NotificationServer {

    public static void main(String[] args) {

        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("📡 Notification Server started on port " + port);

            while (true) {

                Socket socket = serverSocket.accept();

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );

                String message = reader.readLine();

                System.out.println("📩 Notification Received: " + message);

                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}