package controllers;


import business.Book;
import business.BookRepository;
import business.EditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(BookController.CONTACT_ENDPOINT)
public class BookController extends JdbcDaoSupport {
    protected static final String CONTACT_ENDPOINT="api/books";

    @Autowired
    BookRepository bookRepository;

    @Autowired
    EditorRepository editorRepository;

    @GetMapping("/{id}")
    Iterable<Book> getBooks(){
        return this.bookRepository.findAll();
    }

    @GetMapping("/search-by-id")
    Book getBooksById(@PathVariable Long id){
        return this.bookRepository.findOne(id);
    }

    @GetMapping("/search-by-editor")
    Iterable<Book> getByCompanyName(@RequestParam String name) {
        return this.bookRepository.findByEditorName(name);
    }

//    @PostMapping("/create-book")
//    ResponseEntity createContact(@RequestBody Book bookToCreate) {
//        Optional.ofNullable(bookToCreate.editors).ifPresent(
//                editor -> bookToCreate.editors.id = this.editorRepository.findByName(editor.name)
//                        .orElseGet(() -> this.editorRepository.save(bookToCreate.editor)).id);
//
//        this.bookRepository.save(bookToCreate);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(bookToCreate.id).toUri();
//
//        return ResponseEntity.created(location).build();
//    }

    public void create_book(Book book){
        String sql = "INSERT INTO BOOK " +
                "(id, title, id_editor) VALUES (?, ?, ?)";

        getJdbcTemplate().update(sql, new Object[] { book.id,
                book.title,book.editors
        });
    }
}
