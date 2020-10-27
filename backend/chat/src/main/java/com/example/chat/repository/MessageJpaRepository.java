package com.example.chat.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chat.entity.DatabaseMessageEntity;

/**
 * TODO: MessageRepository
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */
public interface MessageJpaRepository extends JpaRepository<DatabaseMessageEntity, UUID> {

}
