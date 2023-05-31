import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Event } from 'src/app/Models/event';

@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.css']
})
export class AddEventComponent {
  url ="http://localhost:9090/";
  event: Event = new Event("", "", new Date(), new Date(), 0, "");

  categories = [
    "Music Festival Camping",
    "Adventure Camping",
    "Family Camping",
    "Yoga and Meditation Camping",
    "Wildlife Camping"
  ]

  constructor(private httpClient: HttpClient){
    
  }

  onSubmit() {
    // Logic to handle form submission
    console.log(this.event);
    
    
  }
  files: File[] = [];

	onSelect(event: any) {
		console.log(event);
		this.files.push(...event.addedFiles);
	}

	onRemove(event: any) {
		console.log(event);
		this.files.splice(this.files.indexOf(event), 1);
	}

}
