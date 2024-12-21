package org.usermanagementservice.usermanagementservice.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service

public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUserEvent(String eventKey, String eventData) {
        kafkaTemplate.send("user-events", eventKey, eventData);
        System.out.println("Event Sent: " + eventData);
    }
}
