import { Component, Input, OnInit } from '@angular/core';
import { Event } from 'app/Models/event';
import { EventService } from 'app/Services/event.service';

@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  styleUrls: ['./event-details.component.css']
})
export class EventDetailsComponent implements OnInit {
  @Input() eventId : any;
  images : string[]=[
    "assets/zaghouan.jpg",
    "assets/bg3.jpg",
    "assets/tbarka.jpg",
    "assets/camp2.jpg"
  ];
  features : Feature[]=[]
  event = new Event("Camping Night in Zaghouan","The Phi Phi Islands, located in Krabi province in southern Thailand, are a group of six islands known for their stunning natural beauty, crystal-clear waters, and white sandy beaches. The two main islands, Koh Phi Phi Don and Koh Phi Phi Leh, are the most popular among tourists. Koh Phi Phi Don is the larger of the two and is home to the main town and beaches,while Koh Phi Phi Leh is a smaller, uninhabited island known for its dramatic limestone cliffs and iconic Maya Bay, which was made famous by the movie “The Beach. Visitors can explore the islands by boat and enjoy activities such as snorkeling, diving, and island-hopping.",
  new Date(),new Date(),25,199,"WELL_BEING_CAMPING_BALNEAOTHERAPY_HAMMAM_SAUNA");
  slides: any[] = new Array(3).fill({id: -1, src: '', title: '', subtitle: ''});
  date = new Date();

  constructor(private eventService: EventService) { }

  ngOnInit(): void {
    this.eventService.getEventById(this.eventId).subscribe(
      reponse =>{
        console.log(reponse);

       // this.event = reponse;
      },
      error=>{
        console.log("error"+error);
      }
    );
    this.features =[
      new Feature("Category", this.formatCategoryName(this.event.category), "bi bi-tag"),
      new Feature("Destination", "Ain Zaghouan", "bi bi-pin-map"),
      new Feature("Age", "+13", "bi bi-person-dash"),
      new Feature("Number of available places", this.event.nbParticipant.toString()+" Places", "bi bi-people-fill"),
      new Feature("Start Date",this.event.startDate.toDateString(),"bi bi-calendar-heart"),
      new Feature("Start Date",this.event.endDate.toDateString(),"bi bi-calendar-heart"),
      new Feature("Price",this.event.price.toString()+"DT","bi bi-coin"),
      new Feature("Organizer","Travel ToDo","bi bi-file-earmark-person-fill")


    ]

    this.slides[0] = {
      src: 'assets/bg5.jpg',
      title:"test1",
      subtitle: "subtitle4"

    };
    this.slides[1] = {
      src: 'assets/bg.png',
      title:"test2",
      subtitle: "subtitle3"


    }
    this.slides[2] = {
      src: 'assets/bg3.jpg',
      title:"test3",
      subtitle: "subtitle1"

    },
    this.slides[3] = {
      src: 'assets/bg4.jpg',
      title:"test3",
      subtitle: "subtitle1"

    }
  }
  formatCategoryName(category: string): string {
    const formatedCategory = category.toLowerCase().replaceAll('_'," ");
    return formatedCategory;
  }

}

class Feature{
  constructor(public type :string, public description: string , public icon :string){

  }

}
