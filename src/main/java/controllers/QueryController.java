package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import business.Book;
import business.BookItem;
import business.BookItemRepository;
import business.BookRepository;
import business.Borrow;
import business.BorrowRepository;
import business.Editor;
import business.EditorRepository;

@RestController
@RequestMapping(QueryController.QUERY_ENDPOINT)
public class QueryController extends JdbcDaoSupport {
    protected static final String QUERY_ENDPOINT="api/queries";

    @Autowired
    EditorRepository editorRepository;
    
    @Autowired
    BookRepository bookRepository;

    @Autowired
	BorrowRepository borrowRepository;
    
    @Autowired
    BookItemRepository bookItemRepository;

    @GetMapping("/editors")
    Iterable<Editor> getEditors(){
        return this.editorRepository.findAll();
    }
    
    @GetMapping("/borrowed_books")
    Iterable<Book> getBooks(){
    	return this.bookRepository.findAll();
    }
    
    @GetMapping("/borrows")
    Iterable<Borrow> getBorrows(){
    	return this.borrowRepository.findAll();
    }
    
    @GetMapping("/book/{id}")
    BookItem getBookItemsById(@PathVariable Long id) {
        return this.bookItemRepository.findOne(id);
    }
    

}
