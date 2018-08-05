package com.yuliia.knowledgebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

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
}
