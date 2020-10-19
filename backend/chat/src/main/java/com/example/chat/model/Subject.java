package com.example.chat.model;

import java.util.List;

import lombok.Data;

/**
 * TODO: Subject
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */

@Data
public class Subject {

	private String subjectName;

	private String subjectCode;

	private String description;

	private List<User> teacherList;

	private Room room;

}
