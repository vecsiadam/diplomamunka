package com.example.chat.kafka.producer.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * TODO: CreateTopicConfig
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */

@Configuration
public class KafkaTopicConfig {

	@Bean
	public NewTopic createTopic() {
		return TopicBuilder.name("chat-rooms").partitions(20).replicas(1).build();
	}
}
