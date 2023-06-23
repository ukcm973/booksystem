package com.booksystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.booksystem.bean.*;
import com.booksystem.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("UserService")
public class UserServiceImpl implements UserService {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository UserRepository;

    public List<User> getAll() {
        return UserRepository.findAll();
    }

    @Override
    public User findByName(String name) {
        return UserRepository.findByName(name);
    }

    public boolean isUserExist(String name) {
        User user = findByName(name);
        if (user != null) {
            logger.info("user not null");
            return true;
        }
        logger.info("user null");
        return false;
    }

    @Override
    public User register(String name, String password) {
        if (isUserExist(name)) {
            throw new RuntimeException("register failed.");
        }

        User user = new User();
        user.setUserName(name);
        user.setPassWord(password);
        return UserRepository.saveAndFlush(user);
    }

    @Override
    public User logIn(String name, String password) {
        User user = findByName(name);
        if (user.getPassWord().equals(password)) {
            return user;
        }
        throw new RuntimeException("login failed.");
    }
}