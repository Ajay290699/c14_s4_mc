package com.niit.C13_s5_pc.servicetest;


import com.niit.C13_s5_pc.domain.Customer;
import com.niit.C13_s5_pc.domain.Product;
import com.niit.C13_s5_pc.exception.CustomerAlreadyExistException;
import com.niit.C13_s5_pc.exception.CustomerNotFoundException;
import com.niit.C13_s5_pc.repository.CustomerRepository;
import com.niit.C13_s5_pc.service.CustomerServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    CustomerServiceImpl customerService;
    private Customer customer;
    private Product product;

    @BeforeEach
    public void setUp(){
        this.product = new Product(1,"Oppo","Good camera");
        this.customer = new Customer(112,"Rakesh",4829895219l,product);
    }

    @Test
    public void givenCustomerToSaveShouldReturnCustomerSuccess() throws CustomerAlreadyExistException {
        //create mock for repo methods
        when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.ofNullable(null));
        when(customerRepository.save(customer)).thenReturn(customer);
        assertEquals(customer,customerService.addCustomer(customer));
        verify(customerRepository,times(1)).save(customer);
    }
    @Test
    public void givenCustomerToSaveShouldReturnCustomerFailuer(){
        when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.ofNullable(customer));
        assertThrows(CustomerAlreadyExistException.class,()->customerService.addCustomer(customer));
    }
    @Test
    public void givenCustomerToDeleteShouldDeleteCustomerSuccess() throws CustomerNotFoundException {
        when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.ofNullable(customer));
        String result=customerService.deleteCustomer(customer.getCustomerId());
        assertEquals("Customer Deleted successfully",result);
    }
    @Test
    public void givenCustomerToDeleteShouldDeleteCustomerFailuer(){
        when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.ofNullable(null));
        assertThrows(CustomerNotFoundException.class,()->customerService.deleteCustomer(customer.getCustomerId()));
    }

    @AfterEach
    public void tearDown(){
        this.product = null;
        this.customer = null;
    }
}
