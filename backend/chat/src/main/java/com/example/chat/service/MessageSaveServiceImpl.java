package com.example.chat.service;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.chat.entity.DatabaseMessageEntity;
import com.example.chat.entity.ElasticsearchMessageEntity;
import com.example.chat.repository.MessageElasticsearchRepository;
import com.example.chat.repository.MessageJpaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO: MessageSaveServiceImpl
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MessageSaveServiceImpl implements MessageSaveService {

	private final MessageElasticsearchRepository elasticsearchRepository;

	private final MessageJpaRepository jpaRepository;

	private final ObjectMapper objectMapper;

	private final SimpMessagingTemplate template;

	@Override
	@MessageMapping("/chat/{roomId}")
	public void sendAndSaveMessage(String value) {
		ElasticsearchMessageEntity elasticsearchMessage;
		DatabaseMessageEntity jpaMessage;
		try {
			elasticsearchMessage = objectMapper.readValue(value, ElasticsearchMessageEntity.class);
			jpaMessage = objectMapper.readValue(value, DatabaseMessageEntity.class);

		} catch (JsonProcessingException e) {
			log.error("Failed to parse json.", e);
			throw new IllegalArgumentException("Failed to parse json.");
		}
		elasticsearchRepository.save(elasticsearchMessage);
		log.info("Save message in elasticsearch: {}", elasticsearchMessage);
		jpaRepository.save(jpaMessage);
		log.info("Save message in db: {}", jpaMessage);
		template.convertAndSend("/topic/chat/" + elasticsearchMessage.getRoom().getRoomId(), value);

	}

}
