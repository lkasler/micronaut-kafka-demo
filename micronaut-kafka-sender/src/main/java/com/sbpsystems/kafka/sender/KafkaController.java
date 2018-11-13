package com.sbpsystems.kafka.sender;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

/**
 * Send message to kafka topic http:server:port/kafka/brand/name
 */
@Controller("/kafka")
public class KafkaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaController.class);

    @Inject
    private ProductClient productClient;

    @Get("/{brand}/{name}") 
    public String send(String brand, String name) {
        String message = String.format("Message sending to partition: %s, name: %s", brand, name);
        LOGGER.debug(message);
        productClient.sendProduct(brand, name);
        return message;
    }

    @Get
    public String index(){
        return "soething";
    }
}
