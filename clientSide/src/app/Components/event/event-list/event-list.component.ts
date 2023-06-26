import { Component } from '@angular/core';
import { Options } from "@angular-slider/ngx-slider";
import { EventService } from 'app/Services/event.service';
import { EventFilterDto } from 'app/Models/dto/eventFilterDto';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent {
  events : any;
  selectedDate: any;

  eventFilter = new EventFilterDto([],0.0,500,new Date('2023-06-01'),new Date('2050-12-12'));
  selectedOptions: { [id: number]: boolean } = {};
  categories :any;
  /// slider variables

  options: Options = {
    floor: 0,
    ceil: 500,
    step:10
  };
  pageSize = 6;
  p: number = 1;
  totalItems = 1;
  constructor(private eventServive : EventService){

  }

  ngOnInit(): void {
    this.eventServive.getEventCategories().subscribe(
      response =>{
        this.categories = response
      },
      error =>{
        console.log(error);
      }
    );

    this.getFilteredEvents();
  }


  priceChanged(event: any){
    console.log("price changed" + event.target.value.value);
  }
  getFilteredEvents(){
    console.log(this.selectedDate);

    this.eventServive.getFilteredEvents(this.eventFilter,this.p-1, this.pageSize).subscribe(
      response =>{
        console.log(response);

        this.events = response.content;
        this.totalItems = response.totalElements;
        console.log(response.totalElements);

      },
      error=>{
        console.log("eroor"+error);
      }
    )
  }

  formatCategoryName(category: string): string {
    const formatedCategory = category.toLowerCase().replaceAll('_'," ");
    return formatedCategory;
  }

  toggleCategorySelection(category: any) {
    if(this.eventFilter.categories){
    const index = this.eventFilter.categories.indexOf(category);
    if (index >= 0) {
      this.eventFilter.categories.splice(index, 1); // Category is already selected, so remove it
    } else {
      this.eventFilter.categories.push(category); // Category is not selected, so add it
    }
  }
  console.log(this.eventFilter)
  this.getFilteredEvents();

}

onPageChange(event: any) {
  console.log(event);
  this.p = event;
  this.getFilteredEvents();
}

}
