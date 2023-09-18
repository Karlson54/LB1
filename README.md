# ЛБ №1 
# Мета ЛБ: 
Розробка програми на мові Java для
керування простою бібліотекою з можливістю додавання, відображення,
пошуку та видалення книг.
# Зробив:
Рубан Андрій
# Група: 
ПД-34
# Викладач:
Гуленко В. С.
# Етап №1
### Створення класів Book та Library:
Першим кроком у розробці програми було створення двох класів - Book і Library.
### Клас Book: 
Клас Book був створений для представлення окремої книги у бібліотеці. У цьому
класі було визначено наступні властивості книги:

Назва (title)

Автор (author)

Номер ISBN (isbn)

Рік видання (year) Для зручності роботи з об'єктами книги, були реалізовані геттери та сеттери
для кожної з властивостей.

```Java
package org.example.model;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int year;

    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }
}
```
### Клас Library: 
Клас Library був створений для управління колекцією книг. В цьому класі були
реалізовані наступні методи та функціональність:

Масив books для зберігання книг у бібліотеці.

Метод addBook(Book book): Додає нову книгу до бібліотеки.

Метод getBooks(): Повертає список всіх книг у бібліотеці.

Метод findBookByTitle(String title): Пошук книги за назвою та повернення знайденої книги.

Метод removeBookByIsbn(String isbn): Видалення книги за номером ISBN.

Ці класи створені з метою структурування даних та реалізації функціональності для керування
бібліотекою книг.

```Java
package org.example.model;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Year: " + book.getYear());
            System.out.println("--------------------------");
        }
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void removeBookByIsbn(String isbn) {
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book with ISBN " + isbn + " removed from the library.");
        } else {
            System.out.println("Book with ISBN " + isbn + " not found in the library.");
        }
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
```
# Етап №2:
### Створення класу “Main”.
Клас **Main** був створений для використання створених раніше класів **Book** та **Library** та
демонстрації їх функціональності. Основні кроки реалізації класу **Main** виглядали так:

Створення об'єкту класу **Library** для управління книгами в бібліотеці.

Додавання декількох книг до бібліотеки, використовуючи метод **addBook(Book book)**.

Виклик методів для відображення списку всіх книг у бібліотеці **(getBooks())**, пошуку книги за
назвою **(findBookByTitle(String title))** та видалення книги за номером ISBN
**(removeBookByIsbn(String isbn))**.

Виведення результатів роботи програми на консоль для демонстрації коректності роботи
методів.

Клас **Main** був створений з метою перевірки та використання функціональності створених
класів **Book** та **Library**.
```Java
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
```
# Етап №3:
### Написання тестів.
**Клас LibraryTest:** Для перевірки правильності реалізації методів класу **Library**, був створений
клас **LibraryTest**. У цьому класі було написано тестові методи для кожної операції:

Метод **testAddBook()**: Тестує додавання нової книги до бібліотеки та перевіряє, чи книга була
додана правильно.

Метод **testFindBookByTitle()**: Перевіряє правильність пошуку книги за назвою в бібліотеці.

Метод **testRemoveBookByIsbn()**: Тестує видалення книги за номером ISBN і перевіряє, чи книга
була видалена коректно.
Усі тести були написані з використанням бібліотеки JUnit та використовувались для перевірки
функціональності класу Library.
```Java
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
```
**Висновок:** У результаті лабораторної роботи було успішно створено програму для керування
бібліотекою книг на Java. Класи Book та Library були реалізовані і протестовані з використанням
тестового класу LibraryTest, що дозволило переконатися в коректності їх роботи.
