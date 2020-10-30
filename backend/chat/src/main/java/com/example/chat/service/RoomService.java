package com.example.chat.service;

import java.util.List;

import com.example.chat.model.Room;

/**
 * TODO: RoomService
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */
public interface RoomService {

	/**
	 * TODO: mit is csinál?
	 *
	 * @return
	 */
	List<Room> getRooms();

	/**
	 * TODO: mit is csinál?
	 *
	 * @param roomId
	 * @return
	 */
	Room getRoomId(Long roomId);

	/**
	 * TODO: mit is csinál?
	 *
	 * @param room
	 */
	void createRoom(Room room);

	/**
	 * TODO: mit is csinál?
	 *
	 * @param roomId
	 */
	void deleteRoomById(Long roomId);

}
