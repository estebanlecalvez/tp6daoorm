package business;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EditorRepository extends CrudRepository<Editor,Long> {
    Optional<Editor> findByName(String name);
}
