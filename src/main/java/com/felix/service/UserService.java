package com.felix.service;

import com.felix.exception.UserException;
import com.felix.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserById(Long id) throws UserException;
    User updateUser(User user, Long id) throws UserException;
    String deleteUser(Long id) throws UserException;
    List<User> getAllUsers();
}
