import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private authService:AuthService) { }

  ngOnInit(): void {
  }
  registrationForm= new FormGroup({
    "userEmail":new FormControl(''),
    "userPassword": new FormControl(''),
    "userPhoneNumber":new FormControl(''),
    "userAdress":new FormControl(''),
  });
   user:any;
   register(){
    alert("register called");
   this.authService.register(this.registrationForm.value).subscribe(
    response=>{
   console.log(response);
   alert("Registered Sucessfully");
   this.authService.getUserByEmailId(this.registrationForm.value.userEmail).subscribe(
    res=>{
      this.user=res;
      console.log(this.user);
        alert("user Id "+this.user);
    })
    })
   }

   alertUser(){
    
   }
 


}
