package com.ironhack.lab3.miguelcaste.repository;

import com.ironhack.lab3.miguelcaste.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {


    Optional<Aircraft> findByModel(String model);

    List<Aircraft> findByModelContains(String model);
}
