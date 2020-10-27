package com.example.chat.kafka.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * TODO: MessageController
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	public String hello() {
		return "hello";
	}
}
