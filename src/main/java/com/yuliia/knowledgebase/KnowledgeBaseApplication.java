package com.yuliia.knowledgebase;

import com.yuliia.knowledgebase.document.Doc;
import com.yuliia.knowledgebase.tag.Tag;
import com.yuliia.knowledgebase.tag.TagRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication(scanBasePackages = "com.yuliia.knowledgebase")
public class KnowledgeBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnowledgeBaseApplication.class, args);
    }

    @Bean
    public DateTimeProvider dateTimeProvider(){
        return () -> new Date().getTime();
    }

    @Bean
    public CommandLineRunner cmd(TagRepository tagRepository, ElasticsearchTemplate elasticsearchTemplate){
        return args -> {
            elasticsearchTemplate.createIndex(Tag.class);
            Tag tag = new Tag().setName("nskd").setId(1L).setDocuments(Arrays.asList(new Doc()));
            tagRepository.save(tag);
        };
    }
}
