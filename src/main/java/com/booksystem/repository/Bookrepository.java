package com.booksystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.booksystem.bean.*;

@Repository("bookrepository")
public interface Bookrepository extends JpaRepository<Book, Long> {
    public List<Book> findByNameLike(String name);
}
