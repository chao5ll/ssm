package com.example.ssm.domain;

import org.apache.ibatis.type.Alias;

import java.time.LocalDate;
@Alias("user")
public class User {
    private int id;
    private String name;
    private LocalDate signInDate;
    private int age;
    public User(){

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(int id, String name, int age,LocalDate signInDate) {
        this.id = id;
        this.name = name;
        this.age=age;
        this.signInDate = signInDate;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getSignInDate() {
        return signInDate;
    }

    public void setSignInDate(LocalDate signInDate) {
        this.signInDate = signInDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", signInDate="  +
                '}';
    }
}
