package br.com.project.bookapi.service;

import java.util.List;

import br.com.project.bookapi.dto.BookDTO;
import br.com.project.bookapi.entity.Book;

public interface BookService {

	List<Book> findAllBooks();

	Book save(BookDTO bookDTO);

	List<Book> findByTitle(String title);

	Book update(String bookId, BookDTO costumerDTO);

}