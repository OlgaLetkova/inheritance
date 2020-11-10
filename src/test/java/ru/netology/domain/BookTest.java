package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book = new Book(1,"RedPill", 400, "Kurpatov");

    @Test
    void matchesForExistingBook() {
      book.matches("RedPill");
      assertEquals(true,book.matches("RedPill"));
    }

    @Test
    void matchesForExistingBookWithoutName() {
        book.matches("Kurpatov");
        assertEquals(true,book.matches("Kurpatov"));
    }

    @Test
    void matchesForNonExistingBook() {
        book.matches("Thirst");
        assertEquals(false,book.matches("Thirst"));
    }
}