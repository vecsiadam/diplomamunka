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

import com.example.chat.model.Room;
import com.example.chat.service.RoomService;

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
public class RoomController {

	private final RoomService roomService;

	@GetMapping("/rooms")
	public ResponseEntity<List<Room>> getRooms() {
		return new ResponseEntity<>(roomService.getRooms(), HttpStatus.OK);
	}

	@GetMapping("/room")
	public ResponseEntity<Room> getRoomById(@RequestParam Long roomId) {
		return new ResponseEntity<>(roomService.getRoomId(roomId), HttpStatus.OK);
	}

	@PostMapping("/room")
	public ResponseEntity<Void> createRoom(@RequestBody Room room) {
		roomService.createRoom(room);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/room")
	public ResponseEntity<Void> updateRoom(@RequestBody Room room) {
		roomService.createRoom(room);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/room")
	public ResponseEntity<Void> deleteRoomById(@RequestParam Long roomId) {
		roomService.deleteRoomById(roomId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
