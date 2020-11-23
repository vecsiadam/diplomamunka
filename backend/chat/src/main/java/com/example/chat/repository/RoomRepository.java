package com.example.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chat.entity.RoomEntity;

/**
 * Repository class to store room in relation database.
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

	RoomEntity findByRoomId(Long roomId);

}
