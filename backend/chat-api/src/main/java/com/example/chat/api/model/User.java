package com.example.chat.api.model;

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

}
