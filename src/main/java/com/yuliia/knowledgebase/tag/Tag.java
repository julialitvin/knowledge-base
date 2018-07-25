package com.yuliia.knowledgebase.tag;

import com.yuliia.knowledgebase.document.Doc;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.ArrayList;
import java.util.List;

@Document(indexName = "tag", type = "tagObject")
public class Tag {

    @Id
    private Long id;
    private String name;
    @Field(type = FieldType.Nested)
    private List<Doc> documents = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public Tag setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Tag setName(String name) {
        this.name = name;
        return this;
    }

    public List<Doc> getDocuments() {
        return documents;
    }

    public Tag setDocuments(List<Doc> documents) {
        this.documents = documents;
        return this;
    }
}
