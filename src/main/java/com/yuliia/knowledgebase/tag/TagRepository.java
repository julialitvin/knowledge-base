package com.yuliia.knowledgebase.tag;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends ElasticsearchRepository<Tag, Long> {

    List<Tag> findAll();

}
