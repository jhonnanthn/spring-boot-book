package br.com.project.bookapi.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import br.com.project.bookapi.entity.Book;

@EnableScan
public interface BookRepository extends CrudRepository<Book, String> {

    List<Book> findByTitle(String title);

    Book findByAuthorAndTitle(String author, String title);
}
