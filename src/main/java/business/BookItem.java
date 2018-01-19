package business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BookItem {
    @Id
    @GeneratedValue
    public Integer id;

    public String itemCode;
    public Book book;

    @OneToMany
    Borrow borrows;
    
    public BookItem(Integer id, String itemCode, Book book) {
        this.id = id;
        this.itemCode = itemCode;
        this.book = book;
    }

	public BookItem() {
		// TODO Auto-generated constructor stub
	}
}
