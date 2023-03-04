package com.example.goodreads;
import java.util.*;
import com.example.goodreads.Book;
public interface BookRepository{
    ArrayList<Book> getBooks();
    Book getBookById(int bookId);
    Book addBook(Book book);
    Book updateBook(int bookId, Book book);
    void deleteBook(int bookId);
}