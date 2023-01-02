package com.example.vehicleDetails.services.userService;

import com.example.vehicleDetails.model.CommonUser;
import com.example.vehicleDetails.model.VUser;
import com.example.vehicleDetails.model.Vehicles;

import java.util.List;

public interface VUserServiceI {
//    public VUser saveUser(VUser user) ;
    public VUser newUser(CommonUser commonUser);
    public VUser addVehicleToCart(String email, Vehicles vehicle);
    public VUser deleteVehicleFromCart(String emailId,String vehicleId);
    public VUser findUserById(String email);
}
