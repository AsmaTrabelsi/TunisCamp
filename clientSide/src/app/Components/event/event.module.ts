import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarouselModule, FormModule } from '@coreui/angular';
import { GoogleMapsModule } from '@angular/google-maps';
import { EventDetailsComponent } from './event-details/event-details.component';
import { AnimatedCardComponent } from './animated-card/animated-card.component';
import { GoogleMapComponent } from './google-map/google-map.component';
import { EventListComponent } from './event-list/event-list.component';
import {MatChipsModule} from '@angular/material/chips';
import {MatSliderModule} from '@angular/material/slider';
import { NgxSliderModule } from '@angular-slider/ngx-slider';
import { EventCardComponent } from './event-card/event-card.component';
import { AddEventComponent } from './add-event/add-event.component';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from 'app/app-routing.module';
import { FormsModule } from '@angular/forms';
import { NgxDropzoneModule } from 'ngx-dropzone';
import { NgxPaginationModule } from 'ngx-pagination';



@NgModule({
  declarations: [
    EventDetailsComponent,
    AnimatedCardComponent,
    GoogleMapComponent,
    EventListComponent,
    EventCardComponent,
    AddEventComponent
  ],

  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CarouselModule,
    GoogleMapsModule,
    MatChipsModule,
    MatSliderModule,
    NgxSliderModule,
    NgxDropzoneModule,
    NgxPaginationModule

  ],
  exports :[
    EventDetailsComponent,
    GoogleMapComponent,
    EventListComponent,
    EventCardComponent,
    AddEventComponent
  ]
})
export class EventModule { }
