package com.example.chat.api.model;

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

	private Room room;

	private User senderUser;

	private String message;

}
