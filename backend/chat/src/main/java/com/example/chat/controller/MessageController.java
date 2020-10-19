package com.example.chat.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.model.Message;
import com.example.chat.model.Role;
import com.example.chat.model.Room;
import com.example.chat.model.Subject;
import com.example.chat.model.User;
import com.example.chat.repository.MessageRepository;

import lombok.RequiredArgsConstructor;

/**
 * TODO: MessageController
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class MessageController {

	private final MessageRepository messageRepository;

	@PostMapping
	public Message saveMessage(@RequestParam String messageString) {
		Message message = new Message();
		message.setMessageId(UUID.randomUUID());
		message.setMessage(messageString);
		Room room = new Room();
		room.setRoomId(UUID.randomUUID());
		room.setRoomName("Diplomatervezés II.");
		message.setRoom(room);
		User user = new User();
		user.setEmail("vecsi1994@hotmail.com");
		user.setName("Vécsi Ádám");
		user.setNeptun("IZBTF9");
		user.setRole(Role.STUDENT);
		Subject subject = new Subject();
		user.setSubjects(List.of(subject));
		message.setSenderUser(user);
		return messageRepository.save(message);
	}
}
