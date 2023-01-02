import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  constructor(private httpClient:HttpClient) { }
  baseUrl="http://localhost:8888/v1/vehicles/"
  v_base_url="http://localhost:8888/v1/user/cart/";
  emailId:any;
  userCart:any;

  getAllVehicles(){
    
    return this.httpClient.get(this.baseUrl+"all");
  }
  addNewVehicle(vehicle:any){
    let httpheaders = new HttpHeaders({
      'Authorization':'Bearer '+localStorage.getItem('jwt')
    });
   let requestOptions = {headers : httpheaders}
  return this.httpClient.post(this.baseUrl+"v/save",vehicle,requestOptions);
  }
  updateVehicle(vehicle:any){
    let httpheaders = new HttpHeaders({
      'Authorization':'Bearer '+localStorage.getItem('jwt')
    });
   let requestOptions = {headers : httpheaders}
    return this.httpClient.put(this.baseUrl+"v/update",vehicle,requestOptions);
  }

  deleteVehicle(id:any){
    let httpheaders = new HttpHeaders({
      'Authorization':'Bearer '+localStorage.getItem('jwt')
    });
   let requestOptions = {headers : httpheaders}
    return this.httpClient.delete(this.baseUrl+"v/"+id,requestOptions);
  }

  addVehicleToCart(vehicle:any){
  return this.httpClient.post(this.v_base_url+this.emailId,vehicle);
  }
  getUserVehicles(){
   return this.httpClient.get(this.v_base_url+this.emailId)
  }

  deleteVehicleFromCart(v:any){
   
    return this.httpClient.delete(this.v_base_url+this.emailId+"/"+v.modelNo);
  }
}
