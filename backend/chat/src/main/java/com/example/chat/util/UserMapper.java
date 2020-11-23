package com.example.chat.util;

import com.example.chat.entity.UserEntity;
import com.example.chat.model.User;

import lombok.experimental.UtilityClass;

/**
 * Mapper class to convert user Entity to DTO and DTO to entity.
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */
@UtilityClass
public final class UserMapper {

	public static UserEntity userToEntity(User user) {
		return new UserEntity(user.getUserId(), user.getNeptun(), user.getName(), user.getEmail(), user.getRole(),
				null);
	}

	public static User entityToUser(UserEntity user) {
		return new User(user.getUserId(), user.getNeptun(), user.getName(), user.getEmail(), user.getRole());
	}
}
