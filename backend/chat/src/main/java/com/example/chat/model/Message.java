package com.example.chat.model;

import java.util.UUID;

import lombok.Data;

/**
 * TODO: Message
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */

@Data
public class Message {

	private UUID messageId;

	private Room room;

	private User senderUser;

	private String message;
}
