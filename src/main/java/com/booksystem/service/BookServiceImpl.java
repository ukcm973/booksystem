package com.booksystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.booksystem.bean.*;
import com.booksystem.repository.*;

@Service("BookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private Bookrepository Bookrepository;

    @Override
    public List<Book> getAll() {
        return Bookrepository.findAll();
    }

    @Override
    public Book save(Book Book) {
        return Bookrepository.saveAndFlush(Book);
    }

    @Override
    public Book find(long id) {
        return Bookrepository.findOne(id);
    }

    @Override
    public List<Book> findByNameLike(String name) {
        return Bookrepository.findByNameLike(name);
    }

    @Override
    public void delete(long id) {
        Bookrepository.delete(id);
    }
}