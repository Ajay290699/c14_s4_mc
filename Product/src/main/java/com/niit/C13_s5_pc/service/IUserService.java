package com.niit.C13_s5_pc.service;

import com.niit.C13_s5_pc.domain.User;
import com.niit.C13_s5_pc.exception.UserAlreadyExistException;
import com.niit.C13_s5_pc.exception.UserNotFoundException;

import java.util.List;

public interface IUserService {

    public User addCustomer(User user) throws UserAlreadyExistException;
    public List<User> getAllCustomer();
    public String deleteCustomer(int id) throws UserNotFoundException;
    public List<User> getCustomerWhoBougthSamsungPhone(String product);
}