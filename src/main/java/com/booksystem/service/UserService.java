package com.booksystem.service;

import java.util.List;
import com.booksystem.bean.*;

public interface UserService {
    public List<User> getAll();

    public User findByName(String name);

    public User logIn(String name, String password);

    public User register(String name, String password);
}