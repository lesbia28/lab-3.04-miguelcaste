package com.ironhack.lab3.miguelcaste.repository;

import com.ironhack.lab3.miguelcaste.model.Aircraft;
import com.ironhack.lab3.miguelcaste.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FlightRepositoryTest {

    @Autowired
    private AircraftRepository aircraftRepository;

    @Autowired
    private FlightRepository flightRepository;

    private Aircraft a1;
    private Aircraft a2;
    private Aircraft a3;
    private Aircraft a4;

    private Flight f1;
    private Flight f2;
    private Flight f3;
    private Flight f4;


    @BeforeEach
    void setUp() {
        a1= new Aircraft("Airbus A330-200",288) ;
        aircraftRepository.save(a1);
        a2= new Aircraft("Airbus A330-300", 278);
        aircraftRepository.save(a2);
        a3= new Aircraft("Airbus A321", 200);
        aircraftRepository.save(a3);
        a4= new Aircraft("Airbus A320", 171);
        aircraftRepository.save(a4);
        f1= new Flight("IB6346", 1000,a1);
        flightRepository.save(f1);
        f2= new Flight("IB6347", 200,a2);
        flightRepository.save(f2);
        f3= new Flight("IB6348", 500,a3);
        flightRepository.save(f3);
        f4= new Flight("IB6349", 2000,a4);
        flightRepository.save(f4);
    }

    @AfterEach
    void tearDown() {
        flightRepository.deleteAll();
        aircraftRepository.deleteAll();

    }

    @Test
    void save_flight_Created(){
        List<Flight> l1=flightRepository.findAll();
        assertEquals(4,l1.size());
        assertEquals(f1.getFlightNumber(),flightRepository.findByFlightNumber(f1.getFlightNumber()).get().getFlightNumber());
    }

    @Test
    void findByFlightNumber_flightNumber_flight(){
        Optional<Flight> optionalFlight=flightRepository.findByFlightNumber("IB6347");
        assertEquals("IB6347",optionalFlight.get().getFlightNumber());

        //Hacer el Assert
    }
    @Test
    void findByMileage_500miles_flight(){
        List<Flight> flights= flightRepository.findByMileageGreaterThan(500);
        assertEquals(2, flights.size());
        assertEquals("IB6346", flights.get(0).getFlightNumber());
    }



}