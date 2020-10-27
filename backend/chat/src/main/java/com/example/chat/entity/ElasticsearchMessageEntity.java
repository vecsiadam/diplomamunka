package com.example.chat.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
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
public class ElasticsearchMessageEntity {

	@Id
	private UUID messageId;

	@Field(type = FieldType.Nested, includeInParent = true)
	private RoomEntity room;

	@Field(type = FieldType.Nested, includeInParent = true)
	private UserEntity senderUser;

	private String message;

	@Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateTime;

}
