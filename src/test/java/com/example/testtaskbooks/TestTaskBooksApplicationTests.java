package com.example.testtaskbooks;

import com.example.testtaskbooks.entity.Book;
import com.example.testtaskbooks.service.BookManagementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TestTaskBooksApplicationTests {

    private BookManagementService bookManagementService;

    @BeforeEach
    public void setUp() {
        bookManagementService = new BookManagementService();
        bookManagementService.addBook(new Book("Убийство в «Восточном экспрессе»", "Агата Кристи", 1934, "978-5-04-088998-3"));
        bookManagementService.addBook(new Book("Автостопом по Галактике", "Дуглас Адамс", 1979, "978-5-17-098748-1"));
    }

    @Test
    public void testAddBook() {
        assertThat(bookManagementService.getBooks().size()).isEqualTo(2);
        bookManagementService.addBook(new Book("Преступление и наказание", "Фёдор Достоевский", 1866, "978-5-907028-28-9"));
        assertThat(bookManagementService.getBooks().size()).isEqualTo(3);
    }

    @Test
    public void testRemoveBook() {
        assertThat(bookManagementService.getBooks().size()).isEqualTo(2);
        bookManagementService.removeBookByIsbn("978-5-04-088998-3");
        assertThat(bookManagementService.getBooks().size()).isEqualTo(1);
    }

    @Test
    public void testBooksCount() {
        assertThat(bookManagementService.searchBookByAuthor("Агата Кристи").size()).isEqualTo(1);
    }
}
