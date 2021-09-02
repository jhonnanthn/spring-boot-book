package br.com.project.bookapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.bookapi.dto.BookDTO;
import br.com.project.bookapi.entity.Book;
import br.com.project.bookapi.service.BookService;

@RestController
@RequestMapping("/book")
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
	@GetMapping
	public List<Book> getAll() {
		return bookService.findAll();
	}

	/**
	 * Get book by id.
	 *
	 * @return book
	 */
	@GetMapping("/{id}")
	public Optional<Book> getBookById(@PathVariable String id) {
		return bookService.findById(id);
	}

	/**
	 * Get all books list.
	 *
	 * @return the list
	 */
	@PostMapping
    public ResponseEntity<Book> save(@Valid @RequestBody BookDTO bookDTO) {
        return new ResponseEntity<Book>(bookService.save(bookDTO), HttpStatus.OK);
    }

	/**
	 * Update book by id.
	 *
	 * @return the book
	 */
	@PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable String id, @Valid @RequestBody BookDTO bookDTO) {
        return new ResponseEntity<Book>(bookService.update(id, bookDTO), HttpStatus.OK);
    }

	/**
	 * Delete book by id.
	 *
	 * @return the book
	 */
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        bookService.delete(id);

		return ResponseEntity.noContent().build();
    }
}
