package com.smartcampus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.*;

public class NotificationServer {

    private static final List<String> notifications =
            Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {

        int port = 5000;

        ExecutorService pool = Executors.newFixedThreadPool(5);

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("📡 Notification Server started on port " + port);

            while (true) {

                Socket socket = serverSocket.accept();

                pool.execute(() -> {

                    try {

                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(socket.getInputStream())
                        );

                        String message = reader.readLine();

                        notifications.add(message);

                        System.out.println(
                                Thread.currentThread().getName()
                                + " -> "
                                + message
                        );

                        socket.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                });

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        pool.shutdown();

    }
}