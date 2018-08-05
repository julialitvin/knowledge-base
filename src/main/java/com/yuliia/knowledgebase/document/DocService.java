package com.yuliia.knowledgebase.document;

import com.yuliia.knowledgebase.DateTimeProvider;
import com.yuliia.knowledgebase.tag.TagRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DocService {

    private final DocRepository docRepository;
    private final DateTimeProvider dateTimeProvider;
    private final TagRepository tagRepository;

    public DocService(DocRepository docRepository,
                      DateTimeProvider dateTimeProvider,
                      TagRepository tagRepository) {
        this.docRepository = docRepository;
        this.dateTimeProvider = dateTimeProvider;
        this.tagRepository = tagRepository;
    }

    public List<DocDto> findAll() {
        return docRepository.findAll()
                .stream()
                .map(DocDto::new)
                .collect(Collectors.toList());
    }

    public Optional<DocDto> findById(long dockId) {
        return docRepository.findById(dockId)
                .map(DocDto::new);
    }

    public DocDto save(DocCommand docCommand) {
        Doc doc = new Doc();
        setPrimitives(docCommand, doc);
        setTags(docCommand, doc);
        return new DocDto(docRepository.save(doc));
    }

    public Optional<DocDto> update(long docId, DocCommand docCommand) {
        return docRepository.findById(docId)
                .map(doc -> {
                    setPrimitives(docCommand, doc);
                    setTags(docCommand, doc);
                    return new DocDto(doc);
                });
    }

    public void delete(long docId) {
        docRepository.deleteById(docId);
    }

    private void setPrimitives(DocCommand docCommand, Doc doc) {
        doc.setName(docCommand.getName());
        doc.setDescription(docCommand.getDescription().orElse(null));
        doc.setCreateDate(new Timestamp(dateTimeProvider.currentTime()));
        doc.setResourceLink(docCommand.getResourceLink());
    }

    private void setTags(DocCommand docCommand, Doc doc) {
        docCommand.getTagIds()
                .stream()
                .map(tagId -> tagRepository.findById(tagId).orElseThrow(IllegalStateException::new))
                .forEach(tag -> doc.getTags().add(tag));
        doc.getTags().removeIf(tag -> !docCommand.getTagIds().contains(tag.getId()));
    }
}
