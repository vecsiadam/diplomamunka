package com.example.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chat.entity.RoomEntity;

/**
 * TODO: RoomRepository
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

	/**
	 * TODO: mit is csinál?
	 *
	 * @param roomId
	 * @return
	 */
	RoomEntity findByRoomId(Long roomId);

}
