package com.felix.service.impl;

import com.felix.exception.UserException;
import com.felix.model.User;
import com.felix.repository.UserRepository;
import com.felix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImplements implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws UserException {
        Optional<User> otp = userRepository.findById(id);
        if(otp.isPresent()){
            return otp.get();
        }
        throw new UserException("User not found for id");
    }

    @Override
    public User updateUser(User user, Long id) throws UserException {
        Optional <User> otp = userRepository.findById(id);
        if(otp.isEmpty()){
            throw new UserException("User not found for id "+id);
        }

        User existingUser = otp.get();

        existingUser.setFullName(user.getFullName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        existingUser.setRole(user.getRole());

        return userRepository.save(existingUser);
    }

    @Override
    public String deleteUser(Long id) throws UserException {
        Optional <User> otp = userRepository.findById(id);
        if(otp.isEmpty()){
            throw new UserException("User not found for id ::"+id);
        }
        userRepository.deleteById(otp.get().getId());
        return "User deleted successfully";
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
