package com.yuliia.knowledgebase;

import com.yuliia.knowledgebase.document.Doc;
import com.yuliia.knowledgebase.tag.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
    public Tag cmd(){
        return new Tag().setName("nskd").setId(1L).setDocuments(Arrays.asList(new Doc()));
    }
}
