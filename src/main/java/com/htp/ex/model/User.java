package com.htp.ex.model;

import java.util.List;

public class User {

    private Integer id;
    private String name;
    private String email;
    private Integer age;

    private List<BookPurchase> purchaseList;

    public User () {}

    public User(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<BookPurchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<BookPurchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
