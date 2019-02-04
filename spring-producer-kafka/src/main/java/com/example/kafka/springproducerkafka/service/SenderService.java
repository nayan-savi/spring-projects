package com.example.kafka.springproducerkafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/send")
@RestController
public class SenderService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/name")
    public String sender() {
        kafkaTemplate.send("kafka_ex", "this is from kafka .. sender SOC_GEN");
        return "Message sent successfully";
    }
}
