package com.example.chat.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.chat.entity.ElasticsearchMessageEntity;

/**
 * Repository class to store messages in Elasticsearch index.
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */
public interface MessageElasticsearchRepository extends ElasticsearchRepository<ElasticsearchMessageEntity, UUID> {

	List<ElasticsearchMessageEntity> findTop5ByRoomRoomIdOrderByDateTimeDesc(Long roomId);

	List<ElasticsearchMessageEntity> findAllByDateTimeBetweenAndRoomRoomId(LocalDateTime from, LocalDateTime to,
			Long roomId);

	@Query("{\"bool\":{\"must\":{\"match\":{\"message\":\"?1\"}},\"filter\":{\"term\":{\"room.roomId\":?0}}}}")
	List<ElasticsearchMessageEntity> findByMessageAndRoomRoomId(Long roomId, String search);

}
