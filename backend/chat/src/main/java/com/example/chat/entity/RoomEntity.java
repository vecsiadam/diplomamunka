package com.example.chat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * TODO: RoomEntity
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */

@Data
@Entity
@Table(name = "room")
public class RoomEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private Long roomId;

	@Column(name = "room_name")
	private String roomName;

	@Column(name = "subject_id")
	private String subjectId;

	@Column(name = "subject_name")
	private String subjectName;

	@Column(name = "description")
	private String description;

}
