import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import {Event} from 'app/Models/event'
import { EventService } from 'app/Services/event.service';
import { ImageService } from 'app/Services/image.service';

@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.css']
})
export class AddEventComponent {
  files: File[] = [];

  event: Event = new Event("", "", new Date(), new Date(),0, "", 0);

  categories = [
    "Music Festival Camping",
    "Adventure Camping",
    "Family Camping",
    "Yoga and Meditation Camping",
    "Wildlife Camping"
  ]

  constructor(private eventService: EventService,private imageService: ImageService){

  }

  addEvent(eventNgForm : NgForm) {
    // Logic to handle form submission
    console.log(this.event);
    if(eventNgForm.valid == false ){
      //||this.files.length <1
      return;
    }
    var res = this.eventService.addEvent(this.event);
    console.log(res);
    this.eventService.addEvent(this.event)
    .subscribe(
      response => {
        console.log('Event added successfully', response);
        // Perform any additional actions after successful addition
      },
      error => {
        console.error('Failed to add event', error);
        // Handle error cases
      });
      
    
  }


	onSelect(event: any) {
		console.log(event);
		this.files.push(...event.addedFiles);
	}

	onRemove(event: any) {
		console.log(event);
		this.files.splice(this.files.indexOf(event), 1);
	}

  async handleFileInputChange(event: any) {
    const file: File = event.target.files[0];
    if (file) {
      try {
        const blob: Blob = await this.imageService.fileToBlob(file);
        console.log(blob);
        // Further processing with the Blob object
      } catch (error) {
        console.error(error);
      }
    }
  }

}
