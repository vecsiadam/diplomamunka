package com.example.chat.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.api.service.MessageSaveService;

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

	private final MessageSaveService messageService;

	@PostMapping("/save")
	public void saveMessage(@RequestBody String value) {
		messageService.saveMessage(value);
	}

}
