import { Component } from '@angular/core';
import { FormControl, Validators  } from '@angular/forms';


@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent {
  backendLocation: string;
  user_input!: string;
  phone_number!: string; // Add the phone_number variable
  additional_notes!: string;
  validateInput(event: any): void {
    const input = event.target.value;
    event.target.value = input.replace(/[^0-9]/g, '');
  }
    validatePhoneNumber(event: any): void {
    const input = event.target.value;
    event.target.value = input.replace(/[^0-9]/g, '');
    this.phone_number = event.target.value;
  }
  backendDate: string; // Assuming you retrieve the date from the backend as a Date object
  backendTime: string; // Assuming you retrieve the time from the backend as a string

  constructor() {
    // Set the backendDate to a specific date
    this.backendDate='30 July 2023';

    // Set the backendTime to a specific time
    this.backendTime = '10:30 PM';
    this.backendLocation = 'Tabarka ';

  }




}
