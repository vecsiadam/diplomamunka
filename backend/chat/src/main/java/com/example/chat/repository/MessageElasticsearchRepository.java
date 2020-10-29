package com.example.chat.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.chat.entity.ElasticsearchMessageEntity;

/**
 * TODO: MessageRepository
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */
public interface MessageElasticsearchRepository extends ElasticsearchRepository<ElasticsearchMessageEntity, UUID> {

	List<ElasticsearchMessageEntity> findTop5ByRoomRoomIdOrderByDateTimeDesc(Long roomId);

}
