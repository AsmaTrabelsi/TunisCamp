import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { EventDto } from 'app/Models/dto/eventDto';

@Component({
  selector: 'app-animated-card',
  templateUrl: './animated-card.component.html',
  styleUrls: ['./animated-card.component.css']
})
export class AnimatedCardComponent {

  relevantEvents: EventDto[]=[
    new EventDto("Mountain Morning","Ain Zaghouan","assets/camp2.jpg"),
    new EventDto("Mountain Morning","Ain Zaghouan", "assets/tbarka.jpg"),
    new EventDto("Mountain Morning","Ain Zaghouan","assets/bg3.jpg"),
    new EventDto("Mountain Morning","Ain Zaghouan", "assets/zaghouan.jpg")

  ];

  constructor(private router: Router){

  }
  selectEvent(){
    this.router.navigate(['/addEvent']);

  }
}
