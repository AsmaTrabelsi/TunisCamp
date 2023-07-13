import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Reservation } from "app/Models/reservation.model";


@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  apiurl ="http://localhost:9090/";

  constructor(private httpClient: HttpClient){
  }


  addReservation(reservation: Reservation) {
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'multipart/form-data');

   return  this.httpClient.post(this.apiurl + 'reservation', reservation) ;

  }

}
