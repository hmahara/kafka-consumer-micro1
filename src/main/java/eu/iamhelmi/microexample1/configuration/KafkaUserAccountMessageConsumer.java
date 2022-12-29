package eu.iamhelmi.microexample1.configuration;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ConditionalOnProperty("kafka.enabled")
@Component
public class KafkaUserAccountMessageConsumer {
	
	
// code work
	@KafkaListener(
		    groupId = "${kafka.topic.useraccount-create.group-id}",
		    //topicPartitions = @TopicPartition(
		      topics = "${kafka.topic.useraccount-create.name}"
		      //,
		      //partitionOffsets = { @PartitionOffset(
		      //  partition = "0", 
		      //  initialOffset = "0") }
	        //)
	        )
		  void listenToPartitionWithOffset(@Payload String message, @Header(KafkaHeaders.OFFSET) int offset) {
		      log.info("Received message [{}] from offset-{}", 
		        message, offset);
		  }

}
