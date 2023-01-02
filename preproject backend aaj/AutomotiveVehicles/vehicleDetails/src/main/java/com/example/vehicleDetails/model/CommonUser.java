package com.example.vehicleDetails.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonUser {
    @Id
    private String userEmail;
    private String userPassword;
    private String userPhoneNumber;
    private String userAdress;
}
