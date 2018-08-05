package com.yuliia.knowledgebase.document;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DocController {

    private final DocService docService;

    public DocController(DocService docService) {
        this.docService = docService;
    }

    @GetMapping("/docs")
    public List<DocDto> findAll() {
        return docService.findAll();
    }

    @GetMapping("/docs/{docId}")
    public ResponseEntity<DocDto> findById(@PathVariable("docId") long dockId) {
        return docService.findById(dockId)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.badRequest()::build);
    }

    @PostMapping("/docs")
    public DocDto save(@RequestBody DocCommand docCommand) {
        return docService.save(docCommand);
    }

    @PutMapping("/docs/{docId}")
    public ResponseEntity<DocDto> update(@PathVariable("docId") long docId,
                                         @RequestBody DocCommand docCommand){
        return docService.update(docId, docCommand)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.badRequest()::build);
    }

    @DeleteMapping("/docs/{docId}")
    public ResponseEntity delete(@PathVariable("docId") long docId){
        docService.delete(docId);
        return ResponseEntity.ok().build();
    }
}
