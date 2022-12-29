package eu.iamhelmi.microexample1.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserAccountKafkaConsumerService {

	@KafkaListener( 
			groupId = "${kafka.topic.useraccount-create.group-id}",
					topicPartitions = @TopicPartition (topic = "${kafka.topic.useraccount-create.name}",
			partitionOffsets = { @PartitionOffset(partition = "${kafka.topic.useraccount-create.partition}",initialOffset = "0") }))
	public void consume(String message) {
		log.info(String.format("Message recieved UserAccountKafkaConsumerService -> %s", message));
	}

//	@KafkaListener(topics = "${kafka.topic.useraccount-create.name}", groupId = "${kafka.topic.useraccount-create.group-id}", containerFactory = "userKafkaListenerContainerFactory")
//	public void consume(UserAccount user) {
//		log.info(String.format("User created -> %s", user));
//	}

}
