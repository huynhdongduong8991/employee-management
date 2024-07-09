package com.dev.account_service.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountService {
    KafkaTemplate<String, Object> kafkaTemplate;

    public void createAccount(String msg) {
        kafkaTemplate.send("noti", "hello user" + msg);
        log.info("data: {}", msg);
    }
}


