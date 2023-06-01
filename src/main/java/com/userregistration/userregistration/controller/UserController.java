package com.userregistration.userregistration.controller;

import com.userregistration.userregistration.entity.User;
import com.userregistration.userregistration.payload.UserDto;
import com.userregistration.userregistration.service.UserService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> downloadUserData() {
        try {
            // Retrieve user data from the database
            List<User> users = userService.getAllUsers();

            // Generate Excel file from the user data
            ByteArrayInputStream excelStream = userService.exportUserDataToExcel(users);

            // Create an InputStreamResource from the Excel file stream
            InputStreamResource excelResource = new InputStreamResource(excelStream);

            // Set response headers
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=userdata.xlsx");

            // Return the Excel file as a response entity
            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(excelResource);
        } catch (Exception e) {
            // Handle any exceptions and log the error
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}