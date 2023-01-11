package com.niit.C13_s5_pc.service;

import com.niit.C13_s5_pc.domain.User;
import com.niit.C13_s5_pc.exception.UserAlreadyExistException;
import com.niit.C13_s5_pc.exception.UserNotFoundException;

import java.util.List;

public interface IUserService {

    public User addUser(User user) throws UserAlreadyExistException;

    public List<User> getAllUser();

    public String deleteUser(int id) throws UserNotFoundException;

    public List<User> getUserWhoBougthSamsungPhone(String product);
}