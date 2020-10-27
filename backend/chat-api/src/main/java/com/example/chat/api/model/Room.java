package com.example.chat.api.model;

import lombok.Data;

/**
 * TODO: Room
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */

@Data
public class Room {

	private Long roomId;

	private String roomName;

	private String subjectId;

	private String subjectName;

	private String description;

}
