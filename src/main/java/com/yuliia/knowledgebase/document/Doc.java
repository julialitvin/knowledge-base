package com.yuliia.knowledgebase.document;

import com.yuliia.knowledgebase.tag.Tag;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Document(indexName = "doc", type = "documentObject")
public class Doc {

    @Id
    private Long id;
    private String name;
    private String description;
    private String resourceLink;
    private Timestamp createDate;
    @Field(type = FieldType.Nested)
    private List<Tag> tags = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public Doc setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Doc setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Doc setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getResourceLink() {
        return resourceLink;
    }

    public Doc setResourceLink(String resourceLink) {
        this.resourceLink = resourceLink;
        return this;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public Doc setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
        return this;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public Doc setTags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }
}
