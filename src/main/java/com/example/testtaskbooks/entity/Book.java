package com.example.testtaskbooks.entity;

public record Book(
    String title,
    String authorName,
    Integer publicationYear,
    String isbn
) {
}
