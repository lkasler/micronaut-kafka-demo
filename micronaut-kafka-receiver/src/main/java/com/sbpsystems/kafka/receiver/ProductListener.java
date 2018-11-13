package com.sbpsystems.kafka.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaListener(offsetReset = OffsetReset.EARLIEST) 
public class ProductListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductListener.class);

    @Topic("${kafka.topic}") 
    public void receive(@KafkaKey String brand, String name) { 
        LOGGER.info("Got Product - {} by {}", name, brand);
    }
}
