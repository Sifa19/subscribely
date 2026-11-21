package com.subscribely.user.dto;

import com.subscribely.user.entity.User;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse{

    private String username;
    private String email;

    public UserResponse(User user){
        this.username = user.getUsername();
        this.email = user.getEmail();
    }

}