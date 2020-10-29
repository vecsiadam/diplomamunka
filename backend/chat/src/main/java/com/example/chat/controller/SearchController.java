package com.example.chat.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.entity.ElasticsearchMessageEntity;
import com.example.chat.service.SearchService;

import lombok.RequiredArgsConstructor;

/**
 * TODO: Mit csinál?
 *
 * @author Adam Vecsi
 * @date 2020-10-29
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class SearchController {

	private final SearchService searchService;

	@GetMapping("/search/last-5-messages")
	public ResponseEntity<List<ElasticsearchMessageEntity>> getLastMessagesByRoomId(@RequestParam Long roomId) {
		return new ResponseEntity<>(searchService.getLastMessagesByRoomId(roomId), HttpStatus.OK);
	}
}
