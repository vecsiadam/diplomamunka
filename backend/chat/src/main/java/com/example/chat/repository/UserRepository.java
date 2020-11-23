package com.example.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chat.entity.UserEntity;

/**
 * Repository class to store users in relation database.
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByUserId(Long userId);

	UserEntity findUserByNeptun(String neptun);

}
