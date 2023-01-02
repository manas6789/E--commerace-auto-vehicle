package com.example.vehicleDetails.controller.UserController;

import com.example.vehicleDetails.model.CommonUser;
import com.example.vehicleDetails.model.VUser;


import com.example.vehicleDetails.model.Vehicles;
import com.example.vehicleDetails.services.userService.VUserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private VUserServiceI vUserServiceI;

    //    http://localhost:65100/v1/user/addnewuser
    @PostMapping("/addnewuser")
    public ResponseEntity<?> newuser(@RequestBody CommonUser commonUser){
        return new ResponseEntity<>(vUserServiceI.newUser(commonUser), HttpStatus.OK);
    }
//    @PostMapping("/post")
//    public ResponseEntity<?> saveUser (VUser vUser)  {
//        return new ResponseEntity<>(vUserServiceI.saveUser(vUser), HttpStatus.CREATED);
//    }
    @PostMapping("/cart/{emailId}")
    public ResponseEntity<?> addVehicletoCart(@RequestBody Vehicles vehicle, @PathVariable String emailId){
        return  new ResponseEntity<>(vUserServiceI.addVehicleToCart(emailId,vehicle),HttpStatus.CREATED);
    }
    @GetMapping("/cart/{emailId}")
    public ResponseEntity<?> getUserVehicles(@PathVariable String emailId){
        return new ResponseEntity<>(vUserServiceI.findUserById(emailId),HttpStatus.CREATED);
    }

    @DeleteMapping("/cart/{emailId}/{vehicleId}")
    public ResponseEntity<?> removeVehicleFromCart(@PathVariable String vehicleId, @PathVariable String emailId){
        return new ResponseEntity<>(vUserServiceI.deleteVehicleFromCart(emailId,vehicleId),HttpStatus.OK);
    }
}
