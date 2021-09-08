package com.ironhack.lab3.miguelcaste.model;

import com.ironhack.lab3.miguelcaste.enums.Status;

import javax.persistence.*;

@Entity
public class Customer {
   // id INT NOT NULL AUTO_INCREMENT,
   // name VARCHAR(255),
   // status VARCHAR(255),
   // mileage INT,
   // PRIMARY KEY(id)//



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;
    private int mileage;

    public Customer() {
    }

    public Customer(String name, Status status, int mileage) {
        this.name = name;
        this.status = status;
        this.mileage = mileage;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

}
