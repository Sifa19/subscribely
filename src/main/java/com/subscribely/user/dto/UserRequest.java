package com.subscribely.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest{

    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String username;

    @NotBlank(message = "Email must not be blank")
    @Email
    private String email;

}