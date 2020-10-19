package com.example.chat.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

/**
 * TODO: Message
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */

@Data
@Document(indexName = "message", shards = 1, replicas = 1)
public class Message {

	@Id
	private UUID messageId;

	@Field(type = FieldType.Nested, includeInParent = true)
	private Room room;

	@Field(type = FieldType.Nested, includeInParent = true)
	private User senderUser;

	private String message;
}
