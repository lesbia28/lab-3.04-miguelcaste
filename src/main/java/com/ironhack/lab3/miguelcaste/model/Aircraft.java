package com.ironhack.lab3.miguelcaste.model;

import javax.persistence.*;
@Entity
public class Aircraft {
    //id INT NOT NULL AUTO_INCREMENT,
    //model VARCHAR(255),
    //seats INT,
    //PRIMARY KEY(id)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private int seats;

    public Aircraft() {
    }

    public Aircraft(String model, int seats) {
        this.model = model;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
