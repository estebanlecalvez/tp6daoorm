package controllers;

import business.Borrow;
import business.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping(BorrowController.BORROW_ENDPOINT)
public class BorrowController extends JdbcDaoSupport {
    protected static final String BORROW_ENDPOINT="api/borrow";

    @Autowired
    BorrowRepository borrowRepository;

    @GetMapping("/{id]")
    Iterable<Borrow> getEditors(){
        return this.borrowRepository.findAll();
    }

    @GetMapping("/search-by-id")
    Borrow getEditorsById(@PathVariable Long id){
        return this.borrowRepository.findOne(id);
    }

    @PostMapping("/create-editor")
    public Borrow createEditor(@Valid @RequestBody Borrow editorToCreate) {
        return  borrowRepository.save(editorToCreate);
    }

    public void update_borrow(Borrow borrow){
        String sql = "UPADTE borrow" +
                "SET borrowEnd = ?" +
                "WHERE borrowed = ?";

        getJdbcTemplate().update(sql, new Object[] {
                borrow.borrowEnd, borrow.borrowed
        });
    }

}
