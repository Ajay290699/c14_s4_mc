//package com.niit.C13_s5_pc.repositorytest;
//
//
//import com.niit.C13_s5_pc.domain.User;
//import com.niit.C13_s5_pc.domain.Product;
//import com.niit.C13_s5_pc.repository.UserRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class UserRepositoryTest {
//
//    @Autowired
//    UserRepository userRepository;
//    User user;
//    Product product;
//
//    @BeforeEach
//    public void setUp(){
//        this.product = new Product(1,"Oppo","Good camera");
//        this.user = new User(112,"Rakesh",4829895219l,product);
//    }
//
//    @Test
//    @DisplayName("This is test for adding user")
//    public void addCustomer(){
//        userRepository.save(user);
//        User c1 = userRepository.findById(user.getUserId()).get();
//
//        assertEquals(c1, user);
//    }
//
//    @Test
//    @DisplayName("This is test for getting all user")
//    public void getAllCustomer(){
//        userRepository.delete(user);
//        userRepository.save(user);
//        List<User> list = userRepository.findAll();
//
//        assertEquals(1,list.size());
//    }
//
//    @Test
//    @DisplayName("This is test for deleting user")
//    public void deleteCustomerById(){
//        userRepository.deleteAll();
//        this.product = new Product(11,"Lava","affordable price");
//        this.user = new User(111,"Amit",482989545l,product);
//        userRepository.save(user);
//        User c1 = userRepository.findById(user.getUserId()).get();
//        userRepository.deleteById(user.getUserId());
//
//        assertEquals(Optional.empty(), userRepository.findById(c1.getUserId()));
//    }
//
//    @AfterEach
//    public void tearDown(){
//        this.product = null;
//        this.user = null;
//    }
//}
