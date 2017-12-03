package pl.madison.dao;

import org.springframework.data.repository.CrudRepository;
import pl.madison.domain.Book;

public interface BookDao extends CrudRepository<Book, Long>{
}
