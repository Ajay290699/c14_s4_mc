package com.niit.C13_s5_pc.repositorytest;


import com.niit.C13_s5_pc.domain.Customer;
import com.niit.C13_s5_pc.domain.Product;
import com.niit.C13_s5_pc.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;
    Customer customer;
    Product product;

    @BeforeEach
    public void setUp(){
        this.product = new Product(1,"Oppo","Good camera");
        this.customer = new Customer(112,"Rakesh",4829895219l,product);
    }

    @Test
    @DisplayName("This is test for adding customer")
    public void addCustomer(){
        customerRepository.save(customer);
        Customer c1 =customerRepository.findById(customer.getCustomerId()).get();

        assertEquals(c1,customer);
    }

    @Test
    @DisplayName("This is test for getting all customer")
    public void getAllCustomer(){
        customerRepository.delete(customer);
        customerRepository.save(customer);
        List<Customer> list = customerRepository.findAll();

        assertEquals(1,list.size());
    }

    @Test
    @DisplayName("This is test for deleting customer")
    public void deleteCustomerById(){
        customerRepository.deleteAll();
        this.product = new Product(11,"Lava","affordable price");
        this.customer = new Customer(111,"Amit",482989545l,product);
        customerRepository.save(customer);
        Customer c1 = customerRepository.findById(customer.getCustomerId()).get();
        customerRepository.deleteById(customer.getCustomerId());

        assertEquals(Optional.empty(),customerRepository.findById(c1.getCustomerId()));
    }

    @AfterEach
    public void tearDown(){
        this.product = null;
        this.customer = null;
    }
}
