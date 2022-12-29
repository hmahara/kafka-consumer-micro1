package eu.iamhelmi.microexample1.component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ConditionalOnProperty("kafka.enabled")
@Component
public class KafkaSearchEngineMessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${kafka.topic.search-engine.name}")
    private String searchEngineTopicName;


    public void sendMessageCreateUserAccount(String message) {
    	log.info("Sending message to Kafka with topic name {} and message content {}", searchEngineTopicName,  message);
    	kafkaTemplate.send(searchEngineTopicName, message);
        
    }

}
