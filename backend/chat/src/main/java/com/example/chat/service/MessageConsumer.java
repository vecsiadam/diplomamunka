package com.example.chat.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

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

	private final MessageSaveService messageSaveService;

	@KafkaListener(topics = { "chat-rooms" })
	public void onMessage(ConsumerRecord<Long, String> consumerRecord)
			throws JsonMappingException, JsonProcessingException {
		log.info("ConsumerRecord : {}", consumerRecord);
		messageSaveService.sendAndSaveMessage(consumerRecord.value());

	}
}
