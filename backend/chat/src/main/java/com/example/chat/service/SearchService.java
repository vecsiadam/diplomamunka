package com.example.chat.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.chat.entity.ElasticsearchMessageEntity;

/**
 * This service manages search and filter in Elasticsearch index.
 *
 * @author Adam Vecsi
 * @date 2020-10-29
 */
public interface SearchService {

	List<ElasticsearchMessageEntity> getLastMessagesByRoomId(Long roomId);

	List<ElasticsearchMessageEntity> getMessagesByRoomIdAndDatetimeBetween(Long roomId, LocalDateTime from,
			LocalDateTime to);

	List<ElasticsearchMessageEntity> searchInMessage(Long roomId, String search);

}
