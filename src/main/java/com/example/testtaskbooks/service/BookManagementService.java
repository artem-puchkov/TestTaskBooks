package com.example.testtaskbooks.service;

import com.example.testtaskbooks.entity.Book;
import com.example.testtaskbooks.exception.BookNotFoundException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
public class BookManagementService {

    private static final String BOOK_WITH_ISBN_DOES_NOT_EXIST = "Книга с таким ISBN не существует";

    private static final String BOOK_WITH_TITLE_DOES_NOT_EXIST = "Книга с таким названием не существует";

    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBookByIsbn(String isbn) {
        Optional<Book> foundBook = books.stream().filter(book -> book.isbn().equals(isbn)).findFirst();

        if (foundBook.isPresent()) {
            books.remove(foundBook.get());
        } else {
            throw new BookNotFoundException(BOOK_WITH_ISBN_DOES_NOT_EXIST);
        }
    }

    public Book searchBookByTitle(String title) {
        Optional<Book> foundBook = books.stream().filter(book -> book.title().equals(title)).findFirst();

        if (foundBook.isPresent()) {
            return foundBook.get();
        } else {
            throw new BookNotFoundException(BOOK_WITH_TITLE_DOES_NOT_EXIST);
        }
    }

    public List<Book> searchBookByAuthor(String author) {
        return books.stream().filter(book -> book.authorName().equals(author)).collect(Collectors.toList());
    }

    public void displayAllBooks() {
        for (Book book: books) {
            System.out.println("Название: " + book.title() + ", Автор: " + book.authorName() + ", Год: " + book.publicationYear() + ", ISBN: " + book.isbn());
        }
    }
}
