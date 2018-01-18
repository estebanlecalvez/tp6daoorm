package controllers;


import business.BookItem;
import business.BookItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(BookItemController.BOOK_ITEM_ENDPOINT)
public class BookItemController extends JdbcDaoSupport {
    protected static final String BOOK_ITEM_ENDPOINT = "api/book-item";

    @Autowired
    BookItemRepository bookItemRepository;

    @GetMapping("/{id]")
    Iterable<BookItem> getBookItems() {
        return this.bookItemRepository.findAll();
    }

    @GetMapping("/search-by-id")
    BookItem getBookItemsById(@PathVariable Long id) {
        return this.bookItemRepository.findOne(id);
    }

    @PostMapping("/create-book-item")
    public BookItem createBookItem(@Valid @RequestBody BookItem bookItemToCreate) {
        return bookItemRepository.save(bookItemToCreate);
    }

    public void create_bookItem(@RequestParam BookItem bookItem){
        String sql = "Insert into bookItem" +
                "(id, title, id_editor) VALUES (?, ?, ?)";

        getJdbcTemplate().update(sql, new Object[] { bookItem.id,
                bookItem.itemCode,bookItem.book
        });
    }
}