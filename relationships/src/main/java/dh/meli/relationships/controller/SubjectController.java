package dh.meli.relationships.controller;

import dh.meli.relationships.model.Subject;
import dh.meli.relationships.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectRepo subjectRepo;

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getById(@PathVariable long id) {
        return ResponseEntity.ok(subjectRepo.findById(id).get());
    }
}
