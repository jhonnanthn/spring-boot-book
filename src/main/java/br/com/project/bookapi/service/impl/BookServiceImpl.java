package br.com.project.bookapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;

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
    public Book save(BookDTO bookDTO) {
//        if(bookRepository.findByCompanyDocumentNumber(bookDTO.getCompanyDocumentNumber()).isPresent()) {
 //           throw new RuntimeException("There is already a customer with this document number");
   //     }
    	try {
            return bookRepository.save(new Book("Jhonnan"));
    	} catch (AmazonServiceException ase) {
    	    System.err.println("Could not complete operation");
    	    System.err.println("Error Message:  " + ase.getMessage());
    	    System.err.println("HTTP Status:    " + ase.getStatusCode());
    	    System.err.println("AWS Error Code: " + ase.getErrorCode());
    	    System.err.println("Error Type:     " + ase.getErrorType());
    	    System.err.println("Request ID:     " + ase.getRequestId());
    	    throw ase;

    	} catch (AmazonClientException ace) {
    	    System.err.println("Internal error occurred communicating with DynamoDB");
    	    System.out.println("Error Message:  " + ace.getMessage());
    	    throw ace;
    	}
    }

    @Override
    public List<Book> findAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

	@Override
    public Book update(String bookId, BookDTO bookDTO) {
        Optional<Book> book = bookRepository.findById(bookId);

        if(book.isEmpty()) {
            throw new RuntimeException("There is no book with this bookId");
        }

        BeanUtils.copyProperties(bookDTO, book.get());

        return bookRepository.save(book.get());
    }

}
