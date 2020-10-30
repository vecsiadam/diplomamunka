package com.example.chat.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.chat.entity.ElasticsearchMessageEntity;
import com.example.chat.repository.MessageElasticsearchRepository;

import lombok.RequiredArgsConstructor;

/**
 * TODO: Mit csinál?
 *
 * @author Adam Vecsi
 * @date 2020-10-29
 */

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

	private final MessageElasticsearchRepository elasticsearchRepostiroy;

	@Override
	public List<ElasticsearchMessageEntity> getLastMessagesByRoomId(Long roomId) {
		List<ElasticsearchMessageEntity> list = elasticsearchRepostiroy.findTop5ByRoomRoomIdOrderByDateTimeDesc(roomId);
		list.sort(Comparator.comparing(ElasticsearchMessageEntity::getDateTime));
		return list;
	}

	@Override
	public List<ElasticsearchMessageEntity> getMessagesByRoomIdAndDatetimeBetween(Long roomId, LocalDateTime from,
			LocalDateTime to) {
		List<ElasticsearchMessageEntity> list = elasticsearchRepostiroy.findAllByDateTimeBetweenAndRoomRoomId(from, to,
				roomId);
		list.sort(Comparator.comparing(ElasticsearchMessageEntity::getDateTime));
		return list;
	}

	@Override
	public List<ElasticsearchMessageEntity> searchInMessage(Long roomId, String search) {
		List<ElasticsearchMessageEntity> list = elasticsearchRepostiroy.findByMessageAndRoomRoomId(roomId, search);
		list.sort(Comparator.comparing(ElasticsearchMessageEntity::getDateTime));
		return list;
	}

}
