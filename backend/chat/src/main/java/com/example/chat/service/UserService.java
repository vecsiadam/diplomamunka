package com.example.chat.service;

import java.util.List;

import com.example.chat.api.model.User;

/**
 * TODO: UserService
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */
public interface UserService {

	/**
	 * TODO: mit is csinál?
	 *
	 * @return
	 */
	List<User> getUsers();

	/**
	 * TODO: mit is csinál?
	 *
	 * @param userId
	 * @return
	 */
	User getUserById(Long userId);

	/**
	 * TODO: mit is csinál?
	 *
	 * @param user
	 */
	void createUser(User user);

	/**
	 * TODO: mit is csinál?
	 *
	 * @param userId
	 */
	void deleteUserById(Long userId);

}
