package com.ironhack.lab3.miguelcaste.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Flight {

    //flight_number VARCHAR(255) NOT NULL,
    //mileage INT,
    //aircraft_id INT,

    @Id
    private String flightNumber;
    private int mileage;

    //    @JoinColumn (name = "aircraft_id")

    @OneToOne
    @JoinColumn (name="aircraft_id")
    private Aircraft aircraft;// Falta OnetoOne

    public Flight() {
    }

    public Flight(String flightNumber, int mileage, Aircraft aircraft) {
        this.flightNumber = flightNumber;
        this.mileage = mileage;
        this.aircraft = aircraft;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
}
