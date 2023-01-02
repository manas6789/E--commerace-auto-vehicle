package com.example.vehicleDetails.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicles {
    @Id
    private String modelNo;
    private String price;
    private String colour;
    private String topSpeed;
    private String engineType;
}
