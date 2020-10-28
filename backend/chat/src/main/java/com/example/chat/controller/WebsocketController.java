package com.example.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.chat.entity.ElasticsearchMessageEntity;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO: Mit csinál?
 *
 * @author Adam Vecsi
 * @date 2020-10-28
 */

@Controller
@Slf4j
public class WebsocketController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public ElasticsearchMessageEntity broadcastGroupMessage(@Payload ElasticsearchMessageEntity message)
			throws Exception {
		return message;
	}

}