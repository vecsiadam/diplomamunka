package com.example.chat.api.model;

import java.util.UUID;

import lombok.Data;

/**
 * TODO: Room
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */

@Data
public class Room {

	private UUID roomId;

	private String roomName;

	private String subject;

	private String description;

}
