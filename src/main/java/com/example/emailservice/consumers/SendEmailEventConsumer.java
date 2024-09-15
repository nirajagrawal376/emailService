package com.example.emailservice.consumers;

import com.example.emailservice.DTO.SendEmailEventDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class SendEmailEventConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "send_email_event", groupId = "emailService")
    public void SendEmailEventHandler(String message) throws JsonProcessingException {
        SendEmailEventDTO event = objectMapper.readValue(message, SendEmailEventDTO.class);

        String body = event.getBody();
        String from = event.getFrom();
        String to = event.getTo();
    }
}
