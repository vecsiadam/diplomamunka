package com.example.chat.util;

import com.example.chat.api.model.User;
import com.example.chat.entity.UserEntity;

import lombok.experimental.UtilityClass;

/**
 * TODO: UserMapper
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */
@UtilityClass
public final class UserMapper {

	public static UserEntity userToEntity(User user) {
		return new UserEntity(user.getUserId(), user.getNeptun(), user.getName(), user.getEmail(), user.getRole());
	}

	public static User entityToUser(UserEntity user) {
		return new User(user.getUserId(), user.getNeptun(), user.getName(), user.getEmail(), user.getRole());
	}
}
