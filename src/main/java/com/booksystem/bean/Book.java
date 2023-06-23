package com.booksystem.bean;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    private long id;

    @Column
    private String name;

    @Column
    private float price;

    @Column
    private String type;

    public Book() {
        super();
    }

    public long getId() {
        return id;
    }

    public String getBookName() {
        return name;
    }

    public void setBookName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }
}