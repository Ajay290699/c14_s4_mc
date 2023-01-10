package com.niit.C13_s5_pc.controllertest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.C13_s5_pc.controller.CustomerController;
import com.niit.C13_s5_pc.domain.Customer;
import com.niit.C13_s5_pc.domain.Product;
import com.niit.C13_s5_pc.exception.CustomerAlreadyExistException;
import com.niit.C13_s5_pc.exception.CustomerNotFoundException;
import com.niit.C13_s5_pc.service.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @Mock
    CustomerServiceImpl customerService;
    @InjectMocks
    CustomerController customerController;
    @Autowired
    MockMvc mockMvc;
    Customer customer;
    Product product;

    @BeforeEach
    void setUp() {
        this.product = new Product(11,"Oppo","Good camera");
        this.customer = new Customer(111,"Rakesh",4829895219l,product);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void givenCustomerToSaveReturnSavedCustomer() throws Exception {
        when(customerService.addCustomer(any())).thenReturn(customer);
        mockMvc.perform(post("/api/v1/customer").
                        contentType(MediaType.APPLICATION_JSON).
                        content(convertJsonToString(customer))).
                andExpect(status().isCreated()).
                andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void givenCustomerToSaveReturnSavedCustomerFailuer() throws Exception {
        when(customerService.addCustomer(any())).thenThrow(CustomerAlreadyExistException.class);
        mockMvc.perform(post("/api/v1/customer").
                        contentType(MediaType.APPLICATION_JSON).
                        content(convertJsonToString(customer))).
                andExpect(status().isConflict()).
                andDo(MockMvcResultHandlers.print());

    }
    @Test
    public void givenCustomerToDeleteCustomer() throws Exception {
        String result="customer deleted succefully";
        when(customerService.deleteCustomer(anyInt())).thenReturn(result);
        mockMvc.perform(delete("/api/v1/customer/1002")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());

    }
    @Test
    public void givenCustomerToDeleteCustomerFailuer() throws Exception {
        String result="customer deleted succefully";
        when(customerService.deleteCustomer(anyInt())).thenThrow(CustomerNotFoundException.class);
        mockMvc.perform(delete("/api/v1/customer/1002")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
    }

    private static String convertJsonToString(final Object ob) {
        String result;
        ObjectMapper mapper=new ObjectMapper();
        try {
            String jsoncontent= mapper.writeValueAsString(ob);
            result=jsoncontent;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            result="Json parser error";
        }
        return result;
    }

}
