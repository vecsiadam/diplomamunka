package com.example.chat.service;

import java.util.List;

import com.example.chat.model.Room;

/**
 * This service manages room business logics.
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */
public interface RoomService {

	List<Room> getRooms();

	Room getRoomId(Long roomId);

	void createRoom(Room room);

	void deleteRoomById(Long roomId);

}
