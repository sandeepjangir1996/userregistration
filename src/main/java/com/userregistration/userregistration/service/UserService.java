package com.userregistration.userregistration.service;


import com.userregistration.userregistration.entity.User;
import com.userregistration.userregistration.payload.UserDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface UserService {

    ByteArrayInputStream exportUserDataToExcel(List<User> users);
    UserDto createUser(UserDto userDTO);

    UserDto getUserById(Long id);

    UserDto getUserByEmail(String email);

    User registerUser(UserDto userDto, MultipartFile photo, String uploadDirectory);
    List<User> getAllUsers();
    // Add  List<User> getAllUsers(); other service methods as needed
}
