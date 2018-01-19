package business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Book {
    @Id
    @GeneratedValue
    public Integer id;

    @ManyToMany(mappedBy="editors")
    public List<Editor> editors;
    
    @OneToMany
    BookItem bookItems;
    
    public String title;

    public Book(Integer id, Editor editor, String title, BookItem bookItems) {
        this.id = id;
        this.editors = editors;
        this.title = title;
        this.bookItems = bookItems;
    }

	public Book() {
		// TODO Auto-generated constructor stub
	}

}
