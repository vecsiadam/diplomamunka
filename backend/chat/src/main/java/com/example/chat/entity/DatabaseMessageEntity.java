package com.example.chat.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * Entity object to store messages in relation database.
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */

@Data
@Entity
@Table(name = "message")
public class DatabaseMessageEntity {

	@Id
	@Column(name = "message_id")
	private UUID messageId;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private RoomEntity room;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity senderUser;

	@Column(name = "message")
	private String message;

	@Column(name = "datetime", columnDefinition = "DATE")
	private LocalDateTime dateTime;

}
