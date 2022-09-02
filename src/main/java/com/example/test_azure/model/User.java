package com.example.test_azure.model;

import javax.persistence.*;

@Entity
public class User {
    @Column
    private String name;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    public User(String name) {
        this.name = name;
    }

    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
