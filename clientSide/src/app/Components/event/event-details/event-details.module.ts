import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarouselModule } from '@coreui/angular';
import { EventDetailsComponent } from './event-details.component';
import { AnimatedCardComponent } from '../animated-card/animated-card.component';



@NgModule({
  declarations: [
    EventDetailsComponent,
    AnimatedCardComponent
  ],
  
  imports: [
    CommonModule,
    CarouselModule
  ],
  exports :[
    EventDetailsComponent
  ]
})
export class EventDetailsModule { }
