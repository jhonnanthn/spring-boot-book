package br.com.project.bookapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.bookapi.dto.BookDTO;
import br.com.project.bookapi.entity.Book;
import br.com.project.bookapi.service.BookService;

@RestController
public class BookController {

	private BookService bookService;

	public BookController(BookService bookService) {
        this.bookService = bookService;
    }

	/**
	 * Get all books list.
	 *
	 * @return the list
	 */
	@GetMapping("/book")
	public List<Book> getAllBooks() {
		return bookService.findAllBooks();
	}

	/**
	 * Get all books list.
	 *
	 * @return the list
	 */
	@PostMapping("/book")
    public ResponseEntity<Book> save(@Valid @RequestBody BookDTO bookDTO) {
        return new ResponseEntity<Book>(bookService.save(bookDTO), HttpStatus.OK);
    }
}
