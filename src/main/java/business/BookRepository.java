package business;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public interface BookRepository extends CrudRepository<Book,Long>{
    Iterable<Book> findByEditorName(String name);
}
