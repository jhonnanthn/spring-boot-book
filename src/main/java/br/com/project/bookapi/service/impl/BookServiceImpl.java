package br.com.project.bookapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.project.bookapi.dto.BookDTO;
import br.com.project.bookapi.entity.Book;
import br.com.project.bookapi.repository.BookRepository;
import br.com.project.bookapi.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> findAll() {
		return (List<Book>) bookRepository.findAll();
	}

	@Override
	public List<Book> findByTitle(String title) {
		return bookRepository.findByTitleContaining(title);
	}

	@Override
	public Optional<Book> findById(String id) {
		return bookRepository.findById(id);
	}

	@Override
	public Book save(BookDTO bookDTO) {
		Book book = bookDTO.bookDTOToBook();
		if (bookRepository.findByAuthorAndTitle(book.getAuthor(), book.getTitle()) != null) {
			throw new RuntimeException("There is already a book with this author and title");
		}
		return bookRepository.save(book);
	}

	@Override
	public Book update(String bookId, BookDTO bookDTO) {
		Optional<Book> book = bookRepository.findById(bookId);

		if (book.isEmpty()) {
			throw new RuntimeException("There is no book with this bookId");
		}

		BeanUtils.copyProperties(bookDTO, book.get());

		return bookRepository.save(book.get());
	}

	@Override
	public void delete(String bookId) {
		Optional<Book> book = bookRepository.findById(bookId);

		if (book.isEmpty()) {
			throw new RuntimeException("There is no book with this bookId");
		}

		bookRepository.delete(book.get());
	}
}
