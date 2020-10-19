package com.example.chat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * TODO: HelloController
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */
@RestController
@RequiredArgsConstructor
public class HelloController {

	@GetMapping("/hello")
	public String getHello() {
		return "Helo!";
	}
}
