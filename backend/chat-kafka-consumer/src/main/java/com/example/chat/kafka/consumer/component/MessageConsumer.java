package com.example.chat.kafka.consumer.component;

import java.util.UUID;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.chat.kafka.consumer.entity.MessageEntity;
import com.example.chat.kafka.consumer.repository.MessageElasticsearchRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO: MessageConsumer
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */

@Component
@Slf4j
@RequiredArgsConstructor
public class MessageConsumer {

	private final ObjectMapper objectMapper;

	private final MessageElasticsearchRepository messageRepository;

	@KafkaListener(topics = { "chat-rooms" })
	public void onMessage(ConsumerRecord<UUID, String> consumerRecord)
			throws JsonMappingException, JsonProcessingException {
		log.info("ConsumerRecord : {}", consumerRecord);
		MessageEntity message = objectMapper.readValue(consumerRecord.value(), MessageEntity.class);
		messageRepository.save(message);
	}
}
