package org.example;

import static org.junit.Assert.*;

import org.example.model.Book;
import org.example.model.Library;
import org.junit.Before;
import org.junit.Test;

public class LibraryTest {
    private Library library;

    @Before
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("Test Book", "Test Author", "1234567890", 2022);
        library.addBook(book);

        assertEquals(1, library.getBooks().size());
        assertEquals(book, library.getBooks().get(0));
    }

    @Test
    public void testFindBookByTitle() {
        Book book1 = new Book("Java Programming", "John Smith", "1234567890", 2020);
        Book book2 = new Book("Python for Beginners", "Alice Johnson", "9876543210", 2019);

        library.addBook(book1);
        library.addBook(book2);

        String searchTitle = "Java Programming";
        Book foundBook = library.findBookByTitle(searchTitle);

        assertNotNull(foundBook);
        assertEquals(searchTitle, foundBook.getTitle());
    }

    @Test
    public void testRemoveBookByIsbn() {
        Book book1 = new Book("Java Programming", "John Smith", "1234567890", 2020);
        Book book2 = new Book("Python for Beginners", "Alice Johnson", "9876543210", 2019);

        library.addBook(book1);
        library.addBook(book2);

        String isbnToDelete = "9876543210";
        library.removeBookByIsbn(isbnToDelete);

        assertEquals(1, library.getBooks().size());
        assertNull(library.findBookByIsbn(isbnToDelete));
    }
}
