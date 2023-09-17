package org.example;

import org.example.model.Library;

import org.example.model.Book;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Java Programming", "John Smith", "1234567890", 2020);
        Book book2 = new Book("Python for Beginners", "Alice Johnson", "9876543210", 2019);

        library.addBook(book1);
        library.addBook(book2);

        System.out.println("All Books in the Library:");
        library.showBooks();

        String searchTitle = "Java Programming";
        Book foundBook = library.findBookByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("Found book by title: " + foundBook.getTitle());
        } else {
            System.out.println("Book with title \"" + searchTitle + "\" not found.");
        }

        String isbnToDelete = "9876543210";
        library.removeBookByIsbn(isbnToDelete);
        library.showBooks();
    }
}
