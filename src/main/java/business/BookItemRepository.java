package business;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookItemRepository extends CrudRepository<BookItem,Long>{
    Optional<BookItem> findByName(String name);
}
