package com.example.chat.service;

import java.util.List;

import com.example.chat.entity.ElasticsearchMessageEntity;

/**
 * TODO: Mit csinál?
 *
 * @author Adam Vecsi
 * @date 2020-10-29
 */
public interface SearchService {

	List<ElasticsearchMessageEntity> getLastMessagesByRoomId(Long roomId);

}
