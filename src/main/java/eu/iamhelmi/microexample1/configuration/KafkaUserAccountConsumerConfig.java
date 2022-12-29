package eu.iamhelmi.microexample1.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class KafkaUserAccountConsumerConfig {

//	@Value(value = "${spring.kafka.producer.bootstrap-servers}")
//	private String bootstrapAddress;

	// @Value(value = "${general.topic.group.id}")
	// private String groupId;

//	@Value(value = "${kafka.topic.useraccount-create.group-id}")
//	private String userAccountGroupId;

	// 1. Consume string data from Kafka

//	@Bean
//	public ConsumerFactory<String, String> consumerFactory() {
//		Map<String, Object> props = new HashMap<>();
//		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//		props.put(ConsumerConfig.GROUP_ID_CONFIG, userAccountGroupId);
//		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
//		return new DefaultKafkaConsumerFactory<>(props);
//	}
//
//	@Bean
//	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
//		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//		factory.setConsumerFactory(consumerFactory());
//		return factory;
//	}

	// 2. Consume user objects from Kafka
	//** Helmi below is used to consume object, see the 

//	  public ConsumerFactory<String, User> userConsumerFactory() {
//	    Map<String, Object> props = new HashMap<>();
//	    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//	    props.put(ConsumerConfig.GROUP_ID_CONFIG, userGroupId);
//	    props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
//	    return new DefaultKafkaConsumerFactory<>(props, 
//	        new StringDeserializer(), 
//	        new JsonDeserializer<>(User.class));
//	  }
//	 
//	  @Bean
//	  public ConcurrentKafkaListenerContainerFactory<String, User> 
//	            userKafkaListenerContainerFactory() {
//	    ConcurrentKafkaListenerContainerFactory<String, User> factory 
//	      = new ConcurrentKafkaListenerContainerFactory<>();
//	    factory.setConsumerFactory(userConsumerFactory());
//	    return factory;
//	  }
}
