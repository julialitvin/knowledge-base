package com.yuliia.knowledgebase.tag;

import com.yuliia.knowledgebase.DateTimeProvider;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TagService {

    private final TagRepository tagRepository;
    private final DateTimeProvider dateTimeProvider;

    public TagService(TagRepository tagRepository,
                      DateTimeProvider dateTimeProvider) {
        this.dateTimeProvider = dateTimeProvider;
        this.tagRepository = tagRepository;
    }

    public List<TagDto> findAll() {
        return tagRepository.findAll()
                .stream()
                .map(TagDto::new)
                .collect(Collectors.toList());
    }

    public Optional<TagDto> findById(long tagId) {
        return tagRepository.findById(tagId)
                .map(TagDto::new);
    }

    public TagDto save(TagCommand tagCommand) {
        Tag doc = new Tag();
        setPrimitives(tagCommand, doc);
        return new TagDto(tagRepository.save(doc));
    }

    public Optional<TagDto> update(long tagId, TagCommand tagCommand) {
        return tagRepository.findById(tagId)
                .map(doc -> {
                    setPrimitives(tagCommand, doc);
                    return new TagDto(doc);
                });
    }

    public void delete(long docId) {
        tagRepository.deleteById(docId);
    }

    private void setPrimitives(TagCommand tagCommand, Tag tag) {
        tag.setName(tagCommand.getName());
    }

}
