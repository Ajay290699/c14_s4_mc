//package com.niit.C13_s5_pc.servicetest;
//
//
//import com.niit.C13_s5_pc.domain.User;
//import com.niit.C13_s5_pc.domain.Product;
//import com.niit.C13_s5_pc.exception.CustomerAlreadyExistException;
//import com.niit.C13_s5_pc.exception.CustomerNotFoundException;
//import com.niit.C13_s5_pc.repository.UserRepository;
//import com.niit.C13_s5_pc.service.CustomerServiceImpl;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class UserServiceTest {
//
//    @Mock
//    UserRepository userRepository;
//    @InjectMocks
//    CustomerServiceImpl customerService;
//    private User user;
//    private Product product;
//
//    @BeforeEach
//    public void setUp(){
//        this.product = new Product(1,"Oppo","Good camera");
//        this.user = new User(112,"Rakesh",4829895219l,product);
//    }
//
//    @Test
//    public void givenCustomerToSaveShouldReturnCustomerSuccess() throws CustomerAlreadyExistException {
//        //create mock for repo methods
//        when(userRepository.findById(user.getCustomerId())).thenReturn(Optional.ofNullable(null));
//        when(userRepository.save(user)).thenReturn(user);
//        assertEquals(user,customerService.addCustomer(user));
//        verify(userRepository,times(1)).save(user);
//    }
//    @Test
//    public void givenCustomerToSaveShouldReturnCustomerFailuer(){
//        when(userRepository.findById(user.getCustomerId())).thenReturn(Optional.ofNullable(user));
//        assertThrows(CustomerAlreadyExistException.class,()->customerService.addCustomer(user));
//    }
//    @Test
//    public void givenCustomerToDeleteShouldDeleteCustomerSuccess() throws CustomerNotFoundException {
//        when(userRepository.findById(user.getCustomerId())).thenReturn(Optional.ofNullable(user));
//        String result=customerService.deleteCustomer(user.getCustomerId());
//        assertEquals("User Deleted successfully",result);
//    }
//    @Test
//    public void givenCustomerToDeleteShouldDeleteCustomerFailuer(){
//        when(userRepository.findById(user.getCustomerId())).thenReturn(Optional.ofNullable(null));
//        assertThrows(CustomerNotFoundException.class,()->customerService.deleteCustomer(user.getCustomerId()));
//    }
//
//    @AfterEach
//    public void tearDown(){
//        this.product = null;
//        this.user = null;
//    }
//}
