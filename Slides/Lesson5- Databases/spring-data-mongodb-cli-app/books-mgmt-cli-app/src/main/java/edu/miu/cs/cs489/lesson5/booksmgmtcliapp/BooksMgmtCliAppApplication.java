package edu.miu.cs.cs489.lesson5.booksmgmtcliapp;

import edu.miu.cs.cs489.lesson5.booksmgmtcliapp.model.Book;
import edu.miu.cs.cs489.lesson5.booksmgmtcliapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class BooksMgmtCliAppApplication {

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(BooksMgmtCliAppApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Hello MongoDB");
            System.out.println("Starting Books Mgmt CLI App...");
            // TODO
            // Add new Book
            var newBook = new Book("111-01938", "My New Book",
                    0.95, "Penguin",
                    LocalDate.of(2022,1,12));
            var bookAdded = addNewBook(newBook);
            System.out.printf("New Book Added: %s\n", bookAdded);
            // PrintAllBooks
            printAllBooks();
            // Count
            System.out.printf("Total number of Books: %d\n", bookRepository.count());
            // Find Books by Publisher
            System.out.println("Books by McGraw:");
            bookRepository.findBooksByPublisher("McGraw-Hill")
                            .forEach(System.out::println);
            // Get only Book-Title and OverdueFee for Book by its isbn
            bookRepository.findByIsbn("012345x")
                            .ifPresentOrElse(
                                    System.out::println,
                                    () -> System.out.println("Book with ISBN, '012345x' is not found!")
                            );
            System.out.println("Books Mgmt CLI App completed");
        };
    }

    private void printAllBooks() {
        bookRepository.findAll()
                .forEach(System.out::println);
    }

    private Book addNewBook(Book newBook) {
        return bookRepository.save(newBook);
    }

}
