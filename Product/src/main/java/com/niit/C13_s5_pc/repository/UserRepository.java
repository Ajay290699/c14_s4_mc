package com.niit.C13_s5_pc.repository;

import com.niit.C13_s5_pc.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, Integer> {

    @Query("{'userProduct.productName':{$in:['?0']}}")
    public List<User> getUserWhoBougthSamsungPhone(String product);
}