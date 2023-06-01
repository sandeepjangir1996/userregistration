package com.userregistration.userregistration.entity;


import com.userregistration.userregistration.payload.UserDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User extends UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String city;
    private String email;
    private String mobile;
    private String state;
    private String country;
    private String pinCode;
    private String password;
    private String photoUrl;
    @Column(name = "photo_file_name")
    private String photoFileName;

    // Constructor, getters, and setters

    public User() {
    }

    public User(String firstName, String lastName, String city, String email, String mobile,
                String state, String country, String pinCode, String password, String photoUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.email = email;
        this.mobile = mobile;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
        this.password = password;
        this.photoUrl = photoUrl;
    }

    // Getters and setters (or use Lombok for automatic generation)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }
    // Other methods, such as toString(), hashCode(), equals(), etc.
}
