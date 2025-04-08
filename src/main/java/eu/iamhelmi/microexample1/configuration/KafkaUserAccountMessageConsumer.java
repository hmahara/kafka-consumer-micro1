package eu.iamhelmi.microexample1.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ConditionalOnProperty("kafka.enabled")
@Component
public class KafkaUserAccountMessageConsumer {
	
	 @Value(value = "${kafka.topic.useraccount-create.group-id}")
	 private String groupId;


	@KafkaListener(groupId = "${kafka.topic.useraccount-create.group-id}",
			// topicPartitions = @TopicPartition(
			topics = "${kafka.topic.useraccount-create.name}"
	// ,
	// partitionOffsets = { @PartitionOffset(
	// partition = "0",
	// initialOffset = "0") }
	// )
	)
	void onMessageUserAccountCreated(@Payload String message, ConsumerRecordMetadata meta) {
		log.info("<< Consumer {} >> - UserAccount is created.  [{}] from offset-{} and partition {}", groupId, message, meta.offset(), meta.partition());

	}
	
	@KafkaListener(groupId = "${kafka.topic.useraccount-create.group-id}",
			topics = "${kafka.topic.useraccount-update.name}"
	)
	void onMessageUserAccountUpdated(@Payload String message, ConsumerRecordMetadata meta) {
		log.info("UserAccount is updated.  [{}] from offset-{} and partition {}", message, meta.offset(), meta.partition());

	}
	
	@KafkaListener(groupId = "${kafka.topic.useraccount-create.group-id}",
			topics = "${kafka.topic.useraccount-delete.name}"
	)
	void onMessageUserAccountDeleted(@Payload String message, ConsumerRecordMetadata meta) {
		log.info("UserAccount is deleted.  [{}] from offset-{} and partition {}", message, meta.offset(), meta.partition());

	}


}
