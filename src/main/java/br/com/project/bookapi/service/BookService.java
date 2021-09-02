package br.com.project.bookapi.service;

import java.util.List;
import java.util.Optional;

import br.com.project.bookapi.dto.BookDTO;
import br.com.project.bookapi.entity.Book;

public interface BookService {

	Optional<Book> findById(String id);

	List<Book> findAll();

	List<Book> findByTitle(String title);

	Book save(BookDTO bookDTO);

	Book update(String bookId, BookDTO costumerDTO);

	void delete(String id);

}