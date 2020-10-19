package com.example.chat.configuration;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * TODO: ElasticsearchConfig
 *
 * @author Adam Vecsi
 * @since 2020. 10. 19
 */

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.chat.repository")
// @ComponentScan(basePackages = { "com.example.chat.service" })
public class ElasticsearchConfig {

	@Value("${chat.elasticsearch.url:localhost:9200}")
	private String elasticsearchUrl;

	@Bean
	public RestHighLevelClient client() {
		ClientConfiguration clientConfiguration = ClientConfiguration.builder().connectedTo(elasticsearchUrl).build();
		return RestClients.create(clientConfiguration).rest();
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
		return new ElasticsearchRestTemplate(this.client());
	}
}
