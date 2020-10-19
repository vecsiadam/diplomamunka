package com.example.chat.model;

import java.util.List;

import lombok.Data;

/**
 * TODO: User
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */

@Data
public class User {

	private String neptun;

	private String name;

	private String email;

	private Role role;

	private List<Subject> subjects;

}
