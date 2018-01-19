package controllers;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import business.Book;
import business.BookDAO;
import business.BookItemRepository;
import business.BookRepository;
import business.BorrowRepository;
import business.Editor;
import business.EditorRepository;

@RestController
@RequestMapping(CommandController.COMMAND_ENDPOINT)
public class CommandController extends JdbcDaoSupport {
    protected static final String COMMAND_ENDPOINT="api/commands";

    @Autowired
    EditorRepository editorRepository;
    
    @Autowired
    BookRepository bookRepository;

    @Autowired
	BorrowRepository borrowRepository;
    
    @Autowired
    BookItemRepository bookItemRepository;
    
    @Autowired
	private BookDAO bookDAO;
    

    

    @PostMapping("/create-book")
    ResponseEntity createContact(@RequestBody Book bookToCreate) {
    	bookDAO.create(bookToCreate);
		return new ResponseEntity(bookToCreate, HttpStatus.OK);
    }
    
}
