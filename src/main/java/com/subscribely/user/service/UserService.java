package com.subscribely.user.service;

import org.springframework.stereotype.Service;
import com.subscribely.user.entity.User;
import com.subscribely.user.repository.UserRepository;
import com.subscribely.user.dto.*;
import com.subscribely.exception.ResourceNotFoundException;

import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService{

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String getUserName() {
        return "John Doe";
    }

    @Transactional
    public UserResponse createUser(UserRequest userRequest){
        User user = new User(userRequest);
        userRepository.save(user);
        return new UserResponse(user);
    }

    public UserResponse getUserById(Long id){
        User user = userRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("User not found with id: "+ id));
        return new UserResponse(user);
    }

}