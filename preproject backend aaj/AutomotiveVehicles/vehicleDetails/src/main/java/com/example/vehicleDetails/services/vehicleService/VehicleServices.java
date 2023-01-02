package com.example.vehicleDetails.services.vehicleService;

import com.example.vehicleDetails.model.Vehicles;

import java.util.List;

public interface VehicleServices {
    public Vehicles addNewVehicle(Vehicles vehicle);
    public Vehicles updateVehicleDetails(Vehicles vehicle);
    public Boolean deleteVehicle(String id);
    public List<Vehicles> getAllVehicles();

}
