package com.example.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chat.entity.UserEntity;

/**
 * TODO: UserRepository
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
