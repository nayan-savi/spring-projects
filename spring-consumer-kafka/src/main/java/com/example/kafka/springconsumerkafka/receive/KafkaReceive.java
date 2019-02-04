package com.example.kafka.springconsumerkafka.receive;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaReceive {

    @KafkaListener(topics = "kafka_ex", groupId = "soc_gen")
    public void listen(String message) {
        System.out.println("Received Messasge in group foo: " + message);
    }
}
