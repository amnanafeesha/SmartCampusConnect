package com.smartcampus.soap;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "borrowResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowResponse {

    private String status;

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}