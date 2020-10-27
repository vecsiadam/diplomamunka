package com.example.chat.kafka.producer.component;

import java.util.UUID;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.example.chat.api.model.Message;
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

	private final KafkaTemplate<UUID, String> kafkaTemplate;

	private final ObjectMapper objectMapper;

	private final String topic = "chat-rooms";

	public void sendMessage(Message message) throws JsonProcessingException {
		UUID key = message.getMessageId();
		String value = objectMapper.writeValueAsString(message);

		ProducerRecord<UUID, String> producerRecord = buildProducerRecord(key, value, topic);
		ListenableFuture<SendResult<UUID, String>> listenableFuture = kafkaTemplate.send(producerRecord);
		listenableFuture.addCallback(new ListenableFutureCallback<SendResult<UUID, String>>() {

			@Override
			public void onSuccess(SendResult<UUID, String> result) {
				handleSuccess(key, value, result);
			}

			@Override
			public void onFailure(Throwable ex) {
				handleFailure(key, value, ex);

			}

		});
	}

	private ProducerRecord<UUID, String> buildProducerRecord(UUID key, String value, String kafkaTopic) {
		return new ProducerRecord<>(kafkaTopic, null, key, value, null);
	}

	private void handleSuccess(UUID key, String value, SendResult<UUID, String> result) {
		log.info("Message sent successfully for the key: {} and the value is {}, partitions is {}", key, value,
				result.getRecordMetadata().partition());
	}

	private void handleFailure(UUID key, String value, Throwable ex) {
		log.error("Error sending message, the exception : {}", ex.getMessage());
		try {
			throw ex;
		} catch (Throwable e) {
			log.error("Error in OnFailure: {}", e.getMessage());
		}
	}
}
