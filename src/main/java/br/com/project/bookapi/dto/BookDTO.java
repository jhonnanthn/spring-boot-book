package br.com.project.bookapi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.project.bookapi.entity.Book;
import br.com.project.bookapi.entity.Person;

public class BookDTO implements Serializable {

	private static final long serialVersionUID = -5730886863789469590L;

	@JsonProperty("author")
    @NotNull
    private Person author;

    @JsonProperty("title")
    @NotNull
    @NotBlank
    private String title;

    @JsonProperty("publisher")
    @NotNull
    @NotBlank
    private String publisher;

    @JsonProperty("year")
    @NotNull
    private int year;

    public Book bookDTOToBook() {
        return new Book(
            this.author,
            this.title.toUpperCase(),
            this.publisher.toUpperCase(),
            this.year
        );
    }

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
