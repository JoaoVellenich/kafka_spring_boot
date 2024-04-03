package com.joaovellenich.kafka.services;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterEventService {
    private final KafkaTemplate<Object, Object> templateKafka;

    public <T> void addEvent(String topic, T data){
        templateKafka.send(topic, data);
    }
}
