package com.example.chat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.api.model.Room;
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
	public List<Room> getRooms() {
		return roomService.getRooms();
	}

	@GetMapping("/room")
	public Room getRoomById(@RequestParam Long roomId) {
		return roomService.getRoomId(roomId);
	}

	@PostMapping("/room")
	public void createRoom(@RequestBody Room room) {
		roomService.createRoom(room);
	}

	@DeleteMapping("/room")
	public void deleteRoomById(@RequestParam Long roomId) {
		roomService.deleteRoomById(roomId);
	}
}