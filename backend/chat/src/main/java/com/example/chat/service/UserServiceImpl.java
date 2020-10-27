package com.example.chat.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.chat.api.model.User;
import com.example.chat.repository.UserRepository;
import com.example.chat.util.UserMapper;

import lombok.RequiredArgsConstructor;

/**
 * TODO: UserServiceImpl
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		return userRepository.findAll().stream().map(UserMapper::entityToUser).collect(Collectors.toList());

	}

	@Override
	public User getUserById(Long userId) {
		return UserMapper.entityToUser(userRepository.findByUserId(userId));

	}

	@Override
	public void createUser(User user) {
		userRepository.save(UserMapper.userToEntity(user));

	}

	@Override
	public void deleteUserById(Long userId) {
		userRepository.deleteById(userId);

	}

}
