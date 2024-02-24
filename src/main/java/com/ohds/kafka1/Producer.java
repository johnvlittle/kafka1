package com.ohds.kafka1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "bets";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String key, String value) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC, key, value);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                logger.info(String.format("\n\n Produced event to topic %s: key = %-10s value = %s \n\n", TOPIC, key, value));
            } else {
                logger.error("Unable to produce event to topic " + TOPIC + ": key = " + key + " value = " + value);
                logger.error("prodcuer exception:", ex);
            }

        });
    }
}
