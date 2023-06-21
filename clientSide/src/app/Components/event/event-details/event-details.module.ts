import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarouselModule } from '@coreui/angular';
import { EventDetailsComponent } from './event-details.component';
import { AnimatedCardComponent } from '../animated-card/animated-card.component';
import { GoogleMapComponent } from '../google-map/google-map.component';
import { GoogleMapsModule } from '@angular/google-maps';
import { EventListComponent } from '../event-list/event-list.component';



@NgModule({
  declarations: [
    EventDetailsComponent,
    AnimatedCardComponent,
    GoogleMapComponent,
    EventListComponent
  ],

  imports: [
    CommonModule,
    CarouselModule,
    GoogleMapsModule

  ],
  exports :[
    EventDetailsComponent,
    GoogleMapComponent,
    EventListComponent
  ]
})
export class EventDetailsModule { }
