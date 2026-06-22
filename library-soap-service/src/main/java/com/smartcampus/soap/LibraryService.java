package com.smartcampus.soap;

import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    public String borrowBook(String bookId, String studentNumber) {

        return "Book " + bookId +
               " borrowed by student " + studentNumber;
    }
}