import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AuthService } from '../auth.service';
import jwt_decode from 'jwt-decode';
import { throttleTime } from 'rxjs';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authService:AuthService , private vehicleService:VehicleService) { }

  ngOnInit(): void {
  }

  loginForm= new FormGroup({
    "userId" : new FormControl(''),
    "userPassword": new FormControl(''),
  });

   responceToken:any;
   decoded:any;
   userRole:any;
   role:any;
   emailId:any;
   
  login(){
    this.authService.login(this.loginForm.value).subscribe(
      response=>{
      console.log(response);
        this.responceToken=response;
      console.log(this.responceToken.token);
       
        const token=this.responceToken.token;

      this.decoded= jwt_decode(token);
        
      console.log(this.decoded);
        
      localStorage.setItem('jwt',this.responceToken.token);
      alert("login success");
      // alert(this.decoded.userObject.userId);
      // this.getUserObjById(this.decoded.userObject.userId);
      this.authService.getUserById(this.decoded.userObject.userId).subscribe(
        responce=>{
       this.role=responce;
       this.vehicleService.emailId=this.role.userEmail;
       this.role=this.role.userRole;
       
       this.authService.role=this.role;
       
       alert("role stored "+this.role);
       this.loginForm.value.userId=null;
       this.loginForm.value.userPassword=null;
        })
  })
}

}
// npm install jwt-decode --save
// import jwt_decode from 'jwt-decode';
