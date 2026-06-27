package com.smartcampus.soap;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "borrowRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowRequest {

    private String studentId;
    private String bookName;

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getBookName() { return bookName; }
    public void setBookName(String bookName) { this.bookName = bookName; }
}