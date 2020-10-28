package com.example.chat.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	}

	@GetMapping("/user")
	public ResponseEntity<User> getUserById(@RequestParam Long userId) {
		return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
	}

	@PostMapping("user")
	public ResponseEntity<Void> createUser(@RequestBody User user) {
		userService.createUser(user);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@PutMapping("user")
	public ResponseEntity<Void> updateUser(@RequestBody User user) {
		userService.createUser(user);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@DeleteMapping("/user")
	public ResponseEntity<Void> deleteRoomById(@RequestParam Long userId) {
		userService.deleteUserById(userId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);

	}
}
