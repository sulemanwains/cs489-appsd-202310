package edu.miu.cs.cs489.lesson5.booksmgmtcliapp.repository;

import edu.miu.cs.cs489.lesson5.booksmgmtcliapp.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findBooksByPublisher(String publisher);

    @Query(value = "{isbn:'?0'}", fields = "{'book-title': 1, 'overdue-fee': 1}")
    Optional<Book> findByIsbn(String isbn);
}
