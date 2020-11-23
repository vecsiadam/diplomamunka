package com.example.chat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class for messages.
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

	private Room room;

	private User senderUser;

	private String message;

}
