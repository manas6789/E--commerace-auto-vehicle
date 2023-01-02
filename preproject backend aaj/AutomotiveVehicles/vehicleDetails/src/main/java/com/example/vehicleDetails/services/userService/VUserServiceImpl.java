package com.example.vehicleDetails.services.userService;

import com.example.vehicleDetails.model.CommonUser;
import com.example.vehicleDetails.model.UserDTO;
import com.example.vehicleDetails.model.VUser;

import com.example.vehicleDetails.model.Vehicles;
import com.example.vehicleDetails.proxy.UserProxy;
import com.example.vehicleDetails.repository.userRepository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VUserServiceImpl implements VUserServiceI {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserProxy userProxy;

//    @Override
//    public VUser saveUser(VUser user) {
//        if(userRepository.findById(user.getUserEmail()).isPresent()){
//            System.out.println("User All Ready Exists");
//            return null;
//        }
//        else{
//            return userRepository.findById(user.getUserEmail()).get();
//        }
//    }

    @Override
    public VUser newUser(CommonUser commonUser) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserEmail(commonUser.getUserEmail());
        userDTO.setUserPassword(commonUser.getUserPassword());
        System.out.println(userDTO);
        ResponseEntity<?> response= userProxy.setUserObjectJWTApp(userDTO);
        System.out.println(response);
        VUser vUser= new VUser(commonUser.getUserEmail(),commonUser.getUserPhoneNumber(),commonUser.getUserAdress(),new ArrayList<>());
        System.out.println(vUser);
        return userRepository.insert(vUser);

    }

    @Override
    public VUser addVehicleToCart(String email, Vehicles vehicle) {
        VUser user;
        if(userRepository.existsById(email)){
            user=userRepository.findById(email).get();
            user.getVehicleCart().add(vehicle);
            return userRepository.save(user);
        }
        else{
            System.out.println("User with that Id not Exist");
            return null;
        }
    }

    @Override
    public VUser deleteVehicleFromCart(String emailId, String modelNo) {
        boolean vehicleExist =false;

        if(userRepository.findById(emailId).isPresent())
        {
            VUser user = userRepository.findById(emailId).get();
            List<Vehicles> vehicle = user.getVehicleCart();
            vehicleExist = vehicle.removeIf(v->v.getModelNo().equals(modelNo));
            System.out.println(vehicleExist);
            userRepository.save(user);
            return user;
        }
        else{
            return null;
        }


    }

    @Override
    public VUser findUserById(String email) {
        return userRepository.findById(email).get();
    }
}
