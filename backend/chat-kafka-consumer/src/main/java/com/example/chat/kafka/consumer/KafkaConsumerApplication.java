package com.example.chat.kafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.chat.api.service.MessageSaveService;

@SpringBootApplication
public class KafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}

	@Service
	public class MessageSaveServiceImpl implements MessageSaveService {

		@Override
		public void saveMessage(String value) {
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<String> request = new HttpEntity<>(value);
			restTemplate.postForObject("http://localhost:8082/message/save", request, String.class);

		}

	}

}
