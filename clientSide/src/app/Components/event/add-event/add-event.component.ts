import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {Event} from 'app/Models/event'
import { EventService } from 'app/Services/event.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.css']
})
export class AddEventComponent implements OnInit{
  files: File[] = [];
  selectedCategory : any;
  event: Event = new Event("", "", new Date(), new Date(),0,0,"");

  categories :string[]=[];

  constructor(private eventService: EventService){

  }
  ngOnInit(): void {
    this.eventService.getEventCategories().subscribe(
      response =>{

        this.categories = response
      },
      error =>{
        console.log(error);
      }
    )
  }


  addEvent(eventNgForm: NgForm){
    if (eventNgForm.valid == false || this.files.length < 1) {
      console.log(eventNgForm.errors);
      return;
    }
    console.log(this.selectedCategory);
    console.log(this.event);
    this.eventService.addEvent(this.event, this.files[0]).subscribe(
      reponse =>{
        console.log('Event added successfully');
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Your event has been saved',
          showConfirmButton: false,
          timer: 2500
        });
        eventNgForm.resetForm();
        this.files = [];
      },
      error=>{
        console.log(error);
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Something went wrong! Unable to upload image',
        });
      }
    );
  }


	onSelect(event: any) {
		console.log(event);
		this.files.push(...event.addedFiles);
	}

	onRemove(event: any) {
		console.log(event);
		this.files.splice(this.files.indexOf(event), 1);
	}

  formatCategoryName(category: string): string {
    const formatedCategory = category.toLowerCase().replaceAll('_'," ");
    return formatedCategory;
  }

}

