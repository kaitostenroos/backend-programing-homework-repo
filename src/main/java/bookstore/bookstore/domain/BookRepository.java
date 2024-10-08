package bookstore.bookstore.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface BookRepository extends CrudRepository<Kirja, Long>{
    List<Kirja> findByIsbn(@Param("isbn") String isbn);
}
