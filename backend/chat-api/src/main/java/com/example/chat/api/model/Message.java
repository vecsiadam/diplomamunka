package com.example.chat.api.model;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO: Message
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

	private UUID messageId;

	private Room room;

	private User senderUser;

	private String message;

	private LocalDateTime dateTime;

}
