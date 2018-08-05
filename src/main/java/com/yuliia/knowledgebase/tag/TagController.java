package com.yuliia.knowledgebase.tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/tags")
    public List<TagDto> findAll() {
        return tagService.findAll();
    }

    @GetMapping("/tags/{tagId}")
    public ResponseEntity<TagDto> findById(@PathVariable("tagId") Long tagId) {
        return tagService.findById(tagId)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.badRequest()::build);
    }

    @PostMapping("/tags")
    public TagDto save(@RequestBody TagCommand tagCommand) {
        return tagService.save(tagCommand);
    }

    @PutMapping("/tags/{tagId}")
    public ResponseEntity<TagDto> update(@PathVariable("tagId") Long tagId,
                                         @RequestBody TagCommand tagCommand){
        return tagService.update(tagId, tagCommand)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.badRequest()::build);
    }

    @DeleteMapping("/tags/{tagId}")
    public ResponseEntity delete(@PathVariable("tagId") Long tagId){
        tagService.delete(tagId);
        return ResponseEntity.ok().build();
    }

}
