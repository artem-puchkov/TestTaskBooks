package com.example.testtaskbooks;

import com.example.testtaskbooks.entity.Book;
import com.example.testtaskbooks.exception.BookNotFoundException;
import com.example.testtaskbooks.service.BookManagementService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookManagementService bookManagementService = new BookManagementService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите опцию: \n 1. Добавить книгу \n 2. Удалить книгу по номеру ISBN" +
                    " \n 3. Найти книгу по названию \n 4. Найти все книги автора \n 5. Отобразить все книги");
            int choiceNumber = scanner.nextInt();
            scanner.nextLine();

            switch (choiceNumber) {
                case 1:
                    System.out.print("Введите название: ");
                    String title = scanner.nextLine();
                    System.out.print("Введите автора: ");
                    String author = scanner.nextLine();
                    System.out.print("Введите год выпуска книги: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите ISBN книги: ");
                    String isbn = scanner.nextLine();

                    bookManagementService.addBook(new Book(title, author, year, isbn));
                    break;

                case 2:
                    System.out.print("Введите ISBN книги, которую хотите удалить: ");
                    String bookIsbn = scanner.nextLine();
                    try {
                        bookManagementService.removeBookByIsbn(bookIsbn);
                    } catch (BookNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Введите название книги, которую вы хотите найти: ");
                    String bookTitle = scanner.nextLine();
                    try {
                        System.out.println(bookManagementService.searchBookByTitle(bookTitle));
                    } catch (BookNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Введите автора, чьи книги вы хотите найти: ");
                    String booksAuthor = scanner.nextLine();
                    System.out.println(bookManagementService.searchBookByAuthor(booksAuthor));
                    break;

                case 5:
                    bookManagementService.displayAllBooks();
            }
        }
    }
}
