package com.example.service;

import com.example.dto.SendMessageDto;
import com.yourapp.ejb.MessageRepository;
import com.yourapp.entity.Message;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class App_AService {

    @Inject
    MessageRepository messageRepository;

    public String sendMessage(SendMessageDto sendMessageDto) {
        Message message = new Message();
        message.setSender(sendMessageDto.getSender());
        message.setContent(sendMessageDto.getContent());
        message.setTimeStamp(LocalDateTime.now());

        messageRepository.saveMessage(message);

        return "Message Sent!";
    }

    public List<Message> getMessages() {
        return messageRepository.fetchMessages();
    }
}
