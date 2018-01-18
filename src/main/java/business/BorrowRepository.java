package business;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BorrowRepository extends CrudRepository<Borrow,Long> {
    Optional<Borrow> findByName(String name);

}
