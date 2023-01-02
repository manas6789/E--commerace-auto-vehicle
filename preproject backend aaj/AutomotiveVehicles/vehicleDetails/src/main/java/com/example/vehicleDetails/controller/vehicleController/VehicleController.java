package com.example.vehicleDetails.controller.vehicleController;

import com.example.vehicleDetails.model.Vehicles;
import com.example.vehicleDetails.services.vehicleService.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//http://localhost:8888/v1/vehicles/v/save
@RestController
//@CrossOrigin("*")
@RequestMapping("/v1/vehicles")
public class VehicleController {
    @Autowired
    VehicleServices vehicleServices;
    @PostMapping("/v/save")
    public ResponseEntity<?> saveNewVehicle(@RequestBody Vehicles vehicle){
        return new ResponseEntity<>(vehicleServices.addNewVehicle(vehicle), HttpStatus.CREATED);
    }
    @PutMapping("/v/update")
    public ResponseEntity<?> upadteVehicleDetails(@RequestBody Vehicles vehicle){
        return new ResponseEntity<>(vehicleServices.updateVehicleDetails(vehicle),HttpStatus.OK);
    }
    @DeleteMapping("/v/{modelNo}")
    public ResponseEntity<?> deleteVehicle(@PathVariable String modelNo){
        return new ResponseEntity<>(vehicleServices.deleteVehicle(modelNo),HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllVehicles(){
      return new ResponseEntity<>(vehicleServices.getAllVehicles(),HttpStatus.OK);
    }
}
