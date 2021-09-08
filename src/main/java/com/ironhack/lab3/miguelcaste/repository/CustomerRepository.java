package com.ironhack.lab3.miguelcaste.repository;

import com.ironhack.lab3.miguelcaste.enums.Status;
import com.ironhack.lab3.miguelcaste.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    Optional<Customer> findByName(String name);

    List<Customer> findByStatus(Status status);
}
