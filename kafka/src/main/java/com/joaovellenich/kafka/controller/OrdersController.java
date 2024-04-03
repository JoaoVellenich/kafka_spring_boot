package com.joaovellenich.kafka.controller;

import com.joaovellenich.kafka.data.OrderData;
import com.joaovellenich.kafka.services.RegisterEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrdersController {

    private final RegisterEventService registerEventService;

    @PostMapping("/")
    public ResponseEntity<String> SaveOrder(@RequestBody OrderData orderData){
        registerEventService.addEvent("SaveOrder", orderData);
        return ResponseEntity.ok().body("Success");
    }
}
