package com.example.chat.util;

import com.example.chat.entity.RoomEntity;
import com.example.chat.model.Room;

import lombok.experimental.UtilityClass;

/**
 * TODO: RoomMapper
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */
@UtilityClass
public final class RoomMapper {

	public static RoomEntity roomToEntity(Room room) {
		return new RoomEntity(room.getRoomId(), room.getRoomName(), room.getSubjectId(), room.getSubjectName(),
				room.getDescription(), null);
	}

	public static Room entityToRoom(RoomEntity room) {
		return new Room(room.getRoomId(), room.getRoomName(), room.getSubjectId(), room.getSubjectName(),
				room.getDescription());
	}
}
