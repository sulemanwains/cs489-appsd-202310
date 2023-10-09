package edu.miu.cs.cs489.lesson5.booksmgmtcliapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document(collection = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private String id;
    private String isbn;
    @Field(name="book-title")
    private String bookTitle;
    @Field(value = "overdue-fee")
    private Double overdueFee;
    private String publisher;
    @Field(value = "date-published")
    private LocalDate datePublished;

    public Book(String isbn, String bookTitle,
                Double overdueFee, String publisher,
                LocalDate datePublished) {
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.overdueFee = overdueFee;
        this.publisher = publisher;
        this.datePublished = datePublished;
    }
}
