package com.booksystem.service;

import java.util.List;

import com.booksystem.bean.*;

public interface BookService {

    public List<Book> getAll();

    public Book save(Book Book);

    public Book find(long id);

    public List<Book> findByNameLike(String name);

    public void delete(long id);

}