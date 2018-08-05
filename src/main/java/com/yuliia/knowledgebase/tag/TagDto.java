package com.yuliia.knowledgebase.tag;

public class TagDto {

    private Long id;
    private String name;


    public TagDto(Tag tag) {
        this.id = tag.getId();
        this.name = tag.getName();
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
