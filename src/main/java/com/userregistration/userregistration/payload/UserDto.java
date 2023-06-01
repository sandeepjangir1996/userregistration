package com.userregistration.userregistration.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data

public class UserDto {
    private String firstName;
    private String lastName;
    private String city;
    private String email;
    private String mobile;
    private String state;
    private String country;
    private String pinCode;
    private String password;

    // Constructor, getters, and setters

    // Example constructor
    public UserDto(String firstName, String lastName, String city, String email, String mobile, String state, String country, String pinCode, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.email = email;
        this.mobile = mobile;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
        this.password = password;
    }

    public UserDto() {

    }

    public void setId(Long id) {
    }

    // Getters and setters

    // ...
}
