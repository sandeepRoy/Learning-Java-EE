package com.yourapp.ejb;

import com.yourapp.entity.Message;
import jakarta.ejb.Stateful;

import java.util.ArrayList;
import java.util.List;

@Stateful
public class MessageRepository {

    public List<Message> messages = new ArrayList<>();

    public String saveMessage(Message message){
        messages.add(message);
        return "Message Sent!";
    }

    public List<Message> fetchMessages() {
        return messages;
    }
}
