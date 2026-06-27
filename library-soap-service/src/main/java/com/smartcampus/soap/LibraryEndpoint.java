package com.smartcampus.soap;

import org.springframework.ws.server.endpoint.annotation.*;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@Endpoint
public class LibraryEndpoint {

    private static final String NAMESPACE =
            "http://smartcampus.com/library";

    @PayloadRoot(namespace = "http://smartcampus.com/library", localPart = "borrowRequest")
    @ResponsePayload
    public BorrowResponse borrowBook(@RequestPayload Element request) {

        String bookName = null;

        NodeList nodes = request.getElementsByTagNameNS(
            "http://smartcampus.com/library",
            "bookName"
        );

        if (nodes.getLength() > 0) {
            bookName = nodes.item(0).getTextContent();
        }

        if (bookName != null && bookName.equalsIgnoreCase("forbidden")) {
            throw new RuntimeException("SOAP FAULT: Book not allowed");
        }

        BorrowResponse response = new BorrowResponse();
        response.setStatus("SUCCESS: Book borrowed");

        return response;
    }
<<<<<<< HEAD
    
    if(request == null || request.isBlank()) {
        throw new RuntimeException("Invalid borrow request");
    }
}
=======
    }
>>>>>>> e78c099 (final update: R6 messaging + R8 SOAP completed)
