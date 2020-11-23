package com.example.chat.service;

/**
 * This service save messages in database and Elasticsearch and send messages to websocket.
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */
public interface MessageSaveService {

	void sendAndSaveMessage(String value);

}
