package com.yourapp.entity;

import jakarta.ejb.Stateful;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private String sender;
    private String content;
    private LocalDateTime timeStamp;

    public Message() {}

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
