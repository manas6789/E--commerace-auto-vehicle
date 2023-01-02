import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient:HttpClient) { }
  AuthUrl="http://localhost:8085/api/jwt/";
  commonUserUrl="http://localhost:8888/v1/user/";

  role:any;
// login method
  login(user:any){
  return   this.httpClient.post(this.AuthUrl+"login",user);
  }

  //registration method
  register(user:any){
 return this.httpClient.post(this.commonUserUrl+"addnewuser",user)
  }
  
   getUserById(id:any){
    return this.httpClient.get(this.AuthUrl+"id/"+id,id);
   }
   getUserByEmailId(userEmail:any){
    return this.httpClient.get(this.AuthUrl+"email/"+userEmail,userEmail);
   }
   logout(){
    localStorage.removeItem("jwt");
    console.log(localStorage.getItem)
    alert("User Logout");
   }
}
