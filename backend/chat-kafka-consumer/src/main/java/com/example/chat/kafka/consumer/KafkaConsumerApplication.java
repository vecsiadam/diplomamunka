package com.example.chat.kafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.example.chat.api.service.MessageSaveService;

@SpringBootApplication
public class KafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}

	/**
	 * If run standalone Kafka Consumer application
	 *
	 * @return
	 */
	@Bean
	public MessageSaveService messageService() {
		return new MessageSaveService() {

			@Override
			public void saveMessage(String value) {
				RestTemplate restTemplate = new RestTemplate();
				HttpEntity<String> request = new HttpEntity<>(value);
				restTemplate.postForObject("http://localhost:8082/message/save", request, String.class);
			}
		};

	}

}
