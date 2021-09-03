package br.com.project.bookapi.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.amazonaws.services.dynamodbv2.document.Page;

import br.com.project.bookapi.entity.Book;
import br.com.project.bookapi.entity.Person;

@EnableScan
public interface BookRepository extends CrudRepository<Book, String> {

    List<Book> findByTitleContaining(String title);

    Book findByAuthorAndTitle(Person author, String title);
    
}
