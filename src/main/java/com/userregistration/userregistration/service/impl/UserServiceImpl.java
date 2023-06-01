package com.userregistration.userregistration.service.impl;


import com.userregistration.userregistration.entity.User;
import com.userregistration.userregistration.exception.UserNotFoundException;
import com.userregistration.userregistration.payload.UserDto;
import com.userregistration.userregistration.repository.UserRepository;
import com.userregistration.userregistration.service.UserService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public ByteArrayInputStream exportUserDataToExcel(List<User> users) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("User Data");
            String[] headers = {"ID", "First Name", "Last Name", "City", "Email", "Mobile", "State", "Country", "Pin Code"};
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            int rowNumber = 1;
            for (User user : users) {
                Row row = sheet.createRow(rowNumber++);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getFirstName());
                row.createCell(2).setCellValue(user.getLastName());
                row.createCell(3).setCellValue(user.getCity());
                row.createCell(4).setCellValue(user.getEmail());
                row.createCell(5).setCellValue(user.getMobile());
                row.createCell(6).setCellValue(user.getState());
                row.createCell(7).setCellValue(user.getCountry());
                row.createCell(8).setCellValue(user.getPinCode());
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);

            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("Failed to export user data to Excel", e);
        }
    }

    @Override
    public User createUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setCity(userDto.getCity());
        user.setEmail(userDto.getEmail());
        user.setMobile(userDto.getMobile());
        user.setState(userDto.getState());
        user.setCountry(userDto.getCountry());
        user.setPinCode(userDto.getPinCode());

        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        user.setPassword(encodedPassword);

        return userRepository.save(user);
    }

    @Override
    public UserDto getUserById(Long id) {
        return null;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return null;
    }

    @Override
    public User registerUser(UserDto userDto, MultipartFile photo, String uploadDirectory) {
        return null;
    }

    // Other methods...

}
