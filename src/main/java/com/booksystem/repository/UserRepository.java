package com.booksystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.booksystem.bean.*;

@Repository("userrepository")
public interface UserRepository extends JpaRepository<User, String> {
    // public User findById(Long id);

    public User findByName(String name);
}
