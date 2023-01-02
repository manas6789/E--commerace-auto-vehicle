package com.example.vehicleDetails.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class VUser {
    @Id
    private String userEmail;
    private String userPhoneNumber;
    private String userAdress;
    private List<Vehicles> vehicleCart;
}
