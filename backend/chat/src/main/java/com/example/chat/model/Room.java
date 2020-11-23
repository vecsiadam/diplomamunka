package com.example.chat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class for rooms.
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

	private Long roomId;

	private String roomName;

	private String subjectId;

	private String subjectName;

	private String description;

}
