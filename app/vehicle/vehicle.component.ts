import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AuthService } from '../auth.service';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css']
})
export class VehicleComponent implements OnInit {

  constructor(private vehicleService:VehicleService, private authServices:AuthService) {
    this.showAllVehicles();
    this.getUserCart();
   }
 
  ngOnInit(): void {
  }
  // getting role from auth service
  role=this.authServices.role;

  vehicleFormDetails1= new FormGroup({
    "modelNo":new FormControl(''),
    "price": new FormControl(''),
    "colour":new FormControl(''),
    "topSpeed":new FormControl(''),
    "engineType":new FormControl('')
  });

  addNewVehicle(){
 this.vehicleService.addNewVehicle(this.vehicleFormDetails1.value).subscribe(
  response=>{
   console.log(response);
   alert("vehicle inserted")
   this.showAllVehicles();
  })
  }

 vehicles:any;
  showAllVehicles(){
    this.vehicleService.getAllVehicles().subscribe(
      responce=>{
        this.vehicles=responce;
        console.log(responce);
        alert(this.role);
        console.log(this.role);
    })
  }

  vehicleFormDetails2= new FormGroup({
    "modelNo":new FormControl(''),
    "price": new FormControl(''),
    "colour":new FormControl(''),
    "topSpeed":new FormControl(''),
    "engineType":new FormControl('')
  });
  flag=false;
  edit(movie:any){
    if(this.flag==false){
      this.flag=true;
    }
    else{
      this.flag=false;
    }
    this.vehicleFormDetails2.setValue(movie);
  }
  updateVehicleDetais(){
    this.vehicleService.updateVehicle(this.vehicleFormDetails2.value).subscribe(
     response=>{
      alert(" updated");
      this.showAllVehicles();
     } )
  }
 
  deleteVehicle(veh:any){
    this.vehicleService.deleteVehicle(veh.modelNo).subscribe(
      response=>{
   alert("deleted")
      })
  }

  logout(){
    this.authServices.logout();
    this.role=null;
    this.vehicleCart=null;
  }
  responceData:any;
  addtoCart(v:any){
    this.vehicleService.addVehicleToCart(v).subscribe(
      response=>{
        this.responceData=response;
        this.vehicleService.userCart=this.responceData.vehicleCart;
        alert("vehicle added to Cart :)");
        this.getUserCart();
      }
    )
  }
  vehicleCart:any;
  getUserCart(){
  this.vehicleService.getUserVehicles().subscribe(
    response=>{
      console.log(response);
      this.vehicleCart=response;
      this.vehicleCart=this.vehicleCart.vehicleCart;
      this.vehicleService.userCart=this.vehicleCart.userCart;
    }
  )
  }
  deleteFromCart(v:any){
    this.vehicleService.deleteVehicleFromCart(v).subscribe(
      response=>{
        alert("vehicle removed from cart");
        this.getUserCart();

        })
      }
    
  }


