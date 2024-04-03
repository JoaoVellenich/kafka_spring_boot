package com.joaovellenich.consumer.servece;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaovellenich.consumer.data.OrderData;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SaveOrderService {
    // So we specify the topic that we want to listen and the groupId of the listener
    // The groupId allow multiples codes to receive the same event
    @KafkaListener(topics = "SaveOrder", groupId = "ConsumerSaveOrder")
    private void execute(ConsumerRecord<String, String> record){
        log.info("Key = {}", record.key());
        log.info("Header = {}",  record.headers());
        log.info("Partition = {}", record.partition());

        String strData = record.value();

        ObjectMapper mapper = new ObjectMapper();
        OrderData order;
        try{
            order = mapper.readValue(strData, OrderData.class);
        }catch (Exception error){
            log.error("Error to convert event - {}", strData);
            log.error(error.getMessage());
            return;
        }

        log.info("Order = {}", order);
    }
}
