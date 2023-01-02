package com.example.vehicleDetails.repository.userRepository;

import com.example.vehicleDetails.model.VUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<VUser,String> {

}
