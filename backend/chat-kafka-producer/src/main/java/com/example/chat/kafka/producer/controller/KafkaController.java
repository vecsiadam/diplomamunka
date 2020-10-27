package com.example.chat.kafka.producer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.api.model.Message;
import com.example.chat.kafka.producer.component.MessageProducer;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.RequiredArgsConstructor;

/**
 * TODO: KafkaController
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka")
public class KafkaController {

	private final MessageProducer messageProducer;

	@PostMapping("/message")
	public ResponseEntity<Message> sendMessage(@RequestBody Message message) throws JsonProcessingException {
		messageProducer.sendMessage(message);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}
}
