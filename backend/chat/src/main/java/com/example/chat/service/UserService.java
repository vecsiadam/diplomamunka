package com.example.chat.service;

import java.util.List;

import com.example.chat.model.User;

/**
 * This service manages user business logics.
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */
public interface UserService {

	List<User> getUsers();

	User getUserById(Long userId);

	void createUser(User user);

	void deleteUserById(Long userId);

	User getUserByNeptun(String neptun);

}
