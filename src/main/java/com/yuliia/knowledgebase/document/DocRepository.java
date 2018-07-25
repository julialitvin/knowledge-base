package com.yuliia.knowledgebase.document;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocRepository extends ElasticsearchRepository<Doc, Long> {
}
