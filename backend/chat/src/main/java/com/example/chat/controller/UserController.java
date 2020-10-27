package com.example.chat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.api.model.User;
import com.example.chat.service.UserService;

import lombok.RequiredArgsConstructor;

/**
 * TODO: MessageController
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class UserController {

	private final UserService userService;

	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/user")
	public User getUserById(@RequestParam Long userId) {
		return userService.getUserById(userId);
	}

	@PostMapping("user")
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
	}

	@DeleteMapping("/user")
	public void deleteRoomById(@RequestParam Long userId) {
		userService.deleteUserById(userId);
	}
}
