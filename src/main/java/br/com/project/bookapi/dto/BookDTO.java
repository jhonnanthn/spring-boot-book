package br.com.project.bookapi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.project.bookapi.entity.Book;
import lombok.Data;

@Data
public class BookDTO implements Serializable {

	private static final long serialVersionUID = -5730886863789469590L;

	@JsonProperty("author")
    @NotNull
    @NotBlank
    private String author;

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
            this.title,
            this.publisher,
            this.year
        );
    }
}
