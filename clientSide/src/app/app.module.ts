import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './Shared/header/header.component';
import { FooterComponent } from './Shared/footer/footer.component';
import { NotFoundComponent } from './Components/not-found/not-found.component';
import { HomeComponent } from './Components/home/home.component';
import { FormsModule } from '@angular/forms';
import { NgxDropzoneModule } from 'ngx-dropzone';
import {HttpClientModule } from '@angular/common/http';
import { AddEventComponent } from './Components/event/add-event/add-event.component';
import { EventDetailsModule } from './Components/event/event-details/event-details.module';
import { GoogleMapComponent } from './Components/event/google-map/google-map.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NotFoundComponent,
    HomeComponent,
    AddEventComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgxDropzoneModule,
    HttpClientModule,
    EventDetailsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
