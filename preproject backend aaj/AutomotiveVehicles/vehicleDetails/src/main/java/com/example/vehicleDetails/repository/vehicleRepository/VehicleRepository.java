package com.example.vehicleDetails.repository.vehicleRepository;

import com.example.vehicleDetails.model.Vehicles;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicles,String> {
}
