package com.smartcampus.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.*;

@Endpoint
public class LibraryEndpoint {

    private static final String NAMESPACE = "http://smartcampus.com/library";

    @Autowired
    private LibraryService service;

    @PayloadRoot(namespace = NAMESPACE, localPart = "borrowRequest")
    @ResponsePayload
    public String borrowBook(@RequestPayload String request) {

        // SIMPLE VERSION (for assignment demo)
        return service.borrowBook("B001", "A1001");
    }
}