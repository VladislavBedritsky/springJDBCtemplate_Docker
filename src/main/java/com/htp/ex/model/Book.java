package com.htp.ex.model;

import java.util.List;

public class Book {

    private Integer id;
    private String name;
    private Integer price;
    private Author author;

    private List<BookPurchase> userList;

    public Book () {
    }

    public Book (String name, Integer price, Author author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<BookPurchase> getUserList() {
        return userList;
    }

    public void setUserList(List<BookPurchase> userList) {
        this.userList = userList;
    }
}
