package com.ironhack.lab3.miguelcaste.repository;

import com.ironhack.lab3.miguelcaste.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight,String> {


    Optional<Flight> findByFlightNumber(String flightNumber);

    List<Flight> findByMileageGreaterThan(int miles);
}
