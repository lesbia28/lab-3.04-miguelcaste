package com.ironhack.lab3.miguelcaste.repository;

import com.ironhack.lab3.miguelcaste.enums.Status;
import com.ironhack.lab3.miguelcaste.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    private Customer c1;
    private Customer c2;
    private Customer c3;
    private Customer c4;

    @BeforeEach
    void setUp() {
        c1=new Customer("Miguel Castelló", Status.None, 50000);
        c2=new Customer("Alba Sosa",Status.Gold,180000);
        c3=new Customer("Francisco Gomez", Status.Gold, 300000);
        c4=new Customer ("Mercedes Aguilar",Status.Silver, 130000);
        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);
        customerRepository.save(c4);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void save_customer_Created(){
        List<Customer> l1=customerRepository.findAll();
        assertEquals(4,l1.size());
        assertEquals(c1.getName(),customerRepository.findByName(c1.getName()).get().getName());
    }

    @Test
    void findByName_name_customer(){
        Customer c5= new Customer("Lucy Morales",Status.Gold,300000);
        customerRepository.save(c5);
        assertEquals("Lucy Morales",customerRepository.findByName("Lucy Morales").get().getName());

    }

   @Test
   void findByStatus_ValidStatus_Customer(){
        assertEquals(1,customerRepository.findByStatus(Status.Silver).size());

   }
}