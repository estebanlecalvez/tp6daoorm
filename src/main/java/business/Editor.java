package business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="editor")
public class Editor {
    @Id
    @GeneratedValue
    public Integer id;

    public String name;
    
    @ManyToMany(mappedBy="books")
    public List<Book> books;
public Editor() {
	// TODO Auto-generated constructor stub
}
    public Editor(Integer id, String name,List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    
    
}
