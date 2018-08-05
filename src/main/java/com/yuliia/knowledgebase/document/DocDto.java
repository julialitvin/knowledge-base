package com.yuliia.knowledgebase.document;

import com.yuliia.knowledgebase.tag.TagDto;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class DocDto {

    private Long id;
    private String name;
    private String description;
    private String resourceLink;
    private Timestamp createDate;
    private List<TagDto> tags;

    public DocDto(Doc doc) {
        this.id = doc.getId();
        this.name = doc.getName();
        this.description = doc.getDescription();
        this.resourceLink = doc.getResourceLink();
        this.createDate = doc.getCreateDate();
        this.tags = doc.getTags().stream().map(TagDto::new).collect(Collectors.toList());
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getResourceLink() {
        return resourceLink;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public List<TagDto> getTags() {
        return tags;
    }
}