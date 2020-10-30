package com.example.chat.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.entity.ElasticsearchMessageEntity;
import com.example.chat.service.SearchService;

import io.swagger.annotations.ApiParam;
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
	public ResponseEntity<List<ElasticsearchMessageEntity>> getLastMessagesByRoomId(
			@RequestParam @ApiParam(required = true, example = "1") Long roomId) {
		return new ResponseEntity<>(searchService.getLastMessagesByRoomId(roomId), HttpStatus.OK);
	}

	@GetMapping("/search/search-from-to-by-date")
	public ResponseEntity<List<ElasticsearchMessageEntity>> getMessagesByRoomIdAndDatetimeBeetween(
			@RequestParam @ApiParam(required = true, example = "1") Long roomId,
			@RequestParam @ApiParam(example = "2020-10-21T17:09:42.411", required = true) String from,
			@RequestParam @ApiParam(example = "2020-11-20T17:09:42.411", required = true) String to) {
		return new ResponseEntity<>(searchService.getMessagesByRoomIdAndDatetimeBetween(roomId,
				LocalDateTime.parse(from), LocalDateTime.parse(to)), HttpStatus.OK);
	}

	@GetMapping("/search/search-in-message")
	public ResponseEntity<List<ElasticsearchMessageEntity>> searchInMessage(
			@RequestParam @ApiParam(required = true, example = "1") Long roomId,
			@RequestParam @ApiParam(required = true, example = "szia") String search) {
		return new ResponseEntity<>(searchService.searchInMessage(roomId, search), HttpStatus.OK);
	}

}
