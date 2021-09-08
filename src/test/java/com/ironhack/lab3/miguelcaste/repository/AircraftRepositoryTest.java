package com.ironhack.lab3.miguelcaste.repository;

import com.ironhack.lab3.miguelcaste.model.Aircraft;
import com.ironhack.lab3.miguelcaste.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AircraftRepositoryTest {
    @Autowired
    private AircraftRepository aircraftRepository;

    private Aircraft a1;
    private Aircraft a2;
    private Aircraft a3;
    private Aircraft a4;


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


    }

    @AfterEach
    void tearDown() {
        aircraftRepository.deleteAll();
    }

    @Test
    void save_aircraft_Created(){
        List<Aircraft> l1=aircraftRepository.findAll();
        assertEquals(4,l1.size());
        assertEquals(a1.getModel(),aircraftRepository.findByModel(a1.getModel()).get().getModel());
    }
    @Test
    void findByModelContains_Model_aircraftBoeing(){
       Aircraft a5= new Aircraft("Boeing 747",300 );
       aircraftRepository.save(a5);
       assertEquals(1,aircraftRepository.findByModelContains("Boeing").size());

    }

}