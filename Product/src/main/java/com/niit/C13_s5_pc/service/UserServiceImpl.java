package com.niit.C13_s5_pc.service;

import com.niit.C13_s5_pc.domain.User;
import com.niit.C13_s5_pc.exception.UserAlreadyExistException;
import com.niit.C13_s5_pc.exception.UserNotFoundException;
import com.niit.C13_s5_pc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) throws UserAlreadyExistException {
        if (userRepository.findById(user.getUserId()).isEmpty()) {
            return userRepository.save(user);
        }
        throw new UserAlreadyExistException();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public String deleteUser(int id) throws UserNotFoundException {
        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException();
        }
        return "User Deleted successfully";
    }

    @Override
    public List<User> getUserWhoBougthSamsungPhone(String product) {
        return userRepository.getUserWhoBougthSamsungPhone(product);
    }
}
