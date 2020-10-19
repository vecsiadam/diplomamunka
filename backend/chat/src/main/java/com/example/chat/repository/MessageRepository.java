package com.example.chat.repository;

import java.util.UUID;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.chat.model.Message;

/**
 * TODO: MessageRepository
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */
public interface MessageRepository extends ElasticsearchRepository<Message, UUID> {

}
