package dh.meli.relationships.controller;

import dh.meli.relationships.dto.AuthorDTO;
import dh.meli.relationships.model.Author;
import dh.meli.relationships.repository.AuthorRepo;
import dh.meli.relationships.service.AuthorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepo repo;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<Author> getById(@PathVariable Long id) {
        return ResponseEntity.ok(repo.findById(id).get());
    }

    @GetMapping("/native/{id}")
    public ResponseEntity<Author> getNativeById(@PathVariable Long id) {
        return ResponseEntity.ok(repo.getNativeById(id));
    }

    @GetMapping("/eag/{id}")
    public ResponseEntity<AuthorDTO> getEagById(@PathVariable Long id) {
        return ResponseEntity.ok(repo.getDtoEagle(id));
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<AuthorDTO> getByIdDTO(@PathVariable Long id) {
        return ResponseEntity.ok(repo.getById(id));
    }

    @PostMapping
    public ResponseEntity<Author> newAuthor(@RequestBody Author author) {
        return ResponseEntity.ok(authorService.save(author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
