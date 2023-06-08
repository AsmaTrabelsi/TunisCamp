import { Component, OnInit } from '@angular/core';
import { Event } from 'app/Models/event';

@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  styleUrls: ['./event-details.component.css']
})
export class EventDetailsComponent implements OnInit {

  images : string[]=[
    "assets/zaghouan.jpg",
    "assets/bg3.jpg",
    "assets/tbarka.jpg",
    "assets/camp2.jpg"

  ];
  features : Feature[]=[
    new Feature("Destination", "Ain Zaghouan", "bi bi-pin-map"),
    new Feature("Age", "+13", "bi bi-person-dash"),
    new Feature("Not allowed", "Ain Zaghouan", "bi bi-pin-map"),
    new Feature("Destination", "Ain Zaghouan", "bi bi-pin-map"),
  ]
  event = new Event("Camping Night in Ain zaghouan","The Phi Phi Islands, located in Krabi province in southern Thailand, are a group of six islands known for their stunning natural beauty, crystal-clear waters, and white sandy beaches. The two main islands, Koh Phi Phi Don and Koh Phi Phi Leh, are the most popular among tourists. Koh Phi Phi Don is the larger of the two and is home to the main town and beaches,while Koh Phi Phi Leh is a smaller, uninhabited island known for its dramatic limestone cliffs and iconic Maya Bay, which was made famous by the movie “The Beach. Visitors can explore the islands by boat and enjoy activities such as snorkeling, diving, and island-hopping.",
  new Date(),new Date(),25,899,"");
  slides: any[] = new Array(3).fill({id: -1, src: '', title: '', subtitle: ''});
  date = new Date();

  constructor() { }

  ngOnInit(): void {

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


}

class Feature{
  constructor(public type :string, public description: string , public icon :string){

  }
}
