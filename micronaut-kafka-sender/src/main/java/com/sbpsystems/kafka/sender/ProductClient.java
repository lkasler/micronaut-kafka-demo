package com.sbpsystems.kafka.sender;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface ProductClient {

    @Topic("${kafka.topic}") 
    void sendProduct(@KafkaKey String brand, String name); 
}
