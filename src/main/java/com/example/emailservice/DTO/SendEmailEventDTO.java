package com.example.emailservice.DTO;

import lombok.Data;

@Data
public class SendEmailEventDTO {
    String to;
    String from;
    String body;

}
