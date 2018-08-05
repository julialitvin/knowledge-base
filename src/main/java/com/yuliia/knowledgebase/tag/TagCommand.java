package com.yuliia.knowledgebase.tag;

import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.Set;

public class TagCommand {

    @NotNull
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
