package com.example.goodreads;
import java.util.*;
import com.example.goodreads.Book;
import com.example.goodreads.BookRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import org.springframework.http.HttpStatus;
public class BookService implements BookRepository{
    private HashMap <Integer, Book> hmap = new HashMap <>(); //Business Logic
    int uniqueBookId=6;
    public BookService(){
        Book b1 = new Book(1, "siri", "siri.jpg");
        Book b2 = new Book(2, "jaggu", "jaggu.jpg");
        Book b3 = new Book(3, "vani", "vani.jpg");
        Book b4 = new Book(4, "HarryPotter", "HarryPotter.jpg");
        Book b5 = new Book(5, "3 Mistakes of my life", "3 mistakes of my life.jpg"); 
        hmap.put(b1.getId(), b1);
        hmap.put(b2.getId(), b2);
        hmap.put(b3.getId(), b3);
        hmap.put(b4.getId(), b4);
        hmap.put(b5.getId(), b5);

    }
    @Override 
    public ArrayList<Book> getBooks(){
        Collection<Book> bookCollection = hmap.values();
        ArrayList<Book> books=new ArrayList<>(bookCollection);
        return books;
    }
    @Override
    public Book getBookById(int bookId){
        Book book = hmap.get(bookId);
        if(book ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return book;
    }
    @Override
    public Book addBook(Book book){
        book.setId(uniqueBookId);
        hmap.put(uniqueBookId, book);
        uniqueBookId+=1;
        return book;
    }
    @Override
    public Book updateBook(int bookId, Book book){
        Book existingBook =hmap.get(bookId);
        if(existingBook==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(book.getName()!= null){
            existingBook.setName(book.getName());
        }
        if(book.getImageUrl()!= null){
            existingBook.setImageUrl(book.getImageUrl());
        }
        return existingBook;
    }
    @Override
    public void deleteBook(int bookId){
        Book book=hmap.get(bookId);
        if(book==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            hmap.remove(bookId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);

        }
    }



}