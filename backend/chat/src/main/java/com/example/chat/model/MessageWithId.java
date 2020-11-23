package com.example.chat.model;

import java.time.LocalDateTime;
import java.util.UUID;

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
public class MessageWithId extends Message {

	private UUID messageId;

	private LocalDateTime dateTime;

}
