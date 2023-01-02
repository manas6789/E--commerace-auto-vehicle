package com.example.vehicleDetails.services.vehicleService;

import com.example.vehicleDetails.model.VUser;
import com.example.vehicleDetails.model.Vehicles;
import com.example.vehicleDetails.repository.vehicleRepository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServicesImpl implements VehicleServices{
    @Autowired
    private VehicleRepository vehicleRepository;
    @Override
    public Vehicles addNewVehicle(Vehicles vehicle) {
        if(vehicleRepository.findById(vehicle.getModelNo()).isPresent()){
            System.out.println("Vehicle With that Model Number Already Exists ");
            return null;
        }
        else{
          return vehicleRepository.insert(vehicle);
        }
    }

    @Override
    public Vehicles updateVehicleDetails(Vehicles vehicle) {
        if(vehicleRepository.findById(vehicle.getModelNo()).isPresent()){
           return vehicleRepository.save(vehicle);
        }
        else {
            System.out.println("Vehicle Not Exist");
            return null;
        }
    }

    @Override
    public Boolean deleteVehicle(String id) {
        if(vehicleRepository.findById(id).isPresent()){
            vehicleRepository.deleteById(id);
            return true;
        }
        else{
            System.out.println("Product with that Id not exist");
            return false;
        }

    }

    @Override
    public List<Vehicles> getAllVehicles() {
        return vehicleRepository.findAll();
    }

}
