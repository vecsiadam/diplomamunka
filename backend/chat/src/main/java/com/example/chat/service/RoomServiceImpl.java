package com.example.chat.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.chat.api.model.Room;
import com.example.chat.repository.RoomRepository;
import com.example.chat.util.RoomMapper;

import lombok.RequiredArgsConstructor;

/**
 * TODO: RoomServiceImpl
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */
@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

	private final RoomRepository roomRepository;

	@Override
	public List<Room> getRooms() {
		return roomRepository.findAll().stream().map(RoomMapper::entityToRoom).collect(Collectors.toList());
	}

	@Override
	public Room getRoomId(Long roomId) {
		return RoomMapper.entityToRoom(roomRepository.findByRoomId(roomId));
	}

	@Override
	public void createRoom(Room room) {
		roomRepository.save(RoomMapper.roomToEntity(room));

	}

	@Override
	public void deleteRoomById(Long roomId) {
		roomRepository.deleteById(roomId);
	}

}
