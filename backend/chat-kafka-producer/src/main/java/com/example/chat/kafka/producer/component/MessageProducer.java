package com.example.chat.kafka.producer.component;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.example.chat.api.model.Message;
import com.example.chat.api.model.MessageWithId;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO: MessageProducer
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */

@Component
@Slf4j
@RequiredArgsConstructor
public class MessageProducer {

	private final KafkaTemplate<Long, String> kafkaTemplate;

	private final ObjectMapper objectMapper;

	private final String topic = "chat-rooms";

	public void sendMessage(Long roomId, Message message) throws JsonProcessingException {

		MessageWithId messageWithId = new MessageWithId();
		messageWithId.setMessageId(UUID.randomUUID());
		messageWithId.setDateTime(LocalDateTime.now());
		messageWithId.setMessage(message.getMessage());
		messageWithId.setRoom(message.getRoom());
		messageWithId.setSenderUser(message.getSenderUser());

		String value = objectMapper.writeValueAsString(messageWithId);

		ProducerRecord<Long, String> producerRecord = buildProducerRecord(roomId, value, topic);
		ListenableFuture<SendResult<Long, String>> listenableFuture = kafkaTemplate.send(producerRecord);
		listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Long, String>>() {

			@Override
			public void onSuccess(SendResult<Long, String> result) {
				handleSuccess(roomId, value, result);
			}

			@Override
			public void onFailure(Throwable ex) {
				handleFailure(roomId, value, ex);

			}

		});
	}

	private ProducerRecord<Long, String> buildProducerRecord(Long key, String value, String kafkaTopic) {
		return new ProducerRecord<Long, String>(kafkaTopic, null, key, value, null);
	}

	private void handleSuccess(Long key, String value, SendResult<Long, String> result) {
		log.info("Message sent successfully for the key: {} and the value is {}, partitions is {}", key, value,
				result.getRecordMetadata().partition());
	}

	private void handleFailure(Long key, String value, Throwable ex) {
		log.error("Error sending message, the exception : {}", ex.getMessage());
		try {
			throw ex;
		} catch (Throwable e) {
			log.error("Error in OnFailure: {}", e.getMessage());
		}
	}
}
