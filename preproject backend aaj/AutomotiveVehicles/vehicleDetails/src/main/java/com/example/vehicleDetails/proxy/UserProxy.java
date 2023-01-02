package com.example.vehicleDetails.proxy;


import com.example.vehicleDetails.model.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="JWT",url = "localhost:8085")
public interface UserProxy {
    @PostMapping("/api/jwt/register")
    public ResponseEntity<?> setUserObjectJWTApp(@RequestBody UserDTO userDTO);
}
