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
import {MatTableModule} from '@angular/material/table';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CarouselModule } from 'ngx-owl-carousel-o';
import { AddCampPlaceComponent } from './Components/campPlace/add-camp-place/add-camp-place.component';
import { CampPlaceDetailsComponent } from './Components/campPlace/camp-place-details/camp-place-details.component';
import { CampPlaceCardComponent } from './Components/campPlace/camp-place-card/camp-place-card.component';
import { CampPlaceListComponent } from './Components/campPlace/camp-place-list/camp-place-list.component';
import {MatChipsModule} from '@angular/material/chips';
import { PagingHeaderComponent } from './Shared/paging-header/paging-header.component';
import {MatIconModule} from '@angular/material/icon';
import {MatMenuModule} from '@angular/material/menu';
import { NgxPaginationModule } from 'ngx-pagination';
import { CampPlaceTableComponent } from './Components/campPlace/camp-place-table/camp-place-table.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NotFoundComponent,
    HomeComponent,
    AddEventComponent,
    AddCampPlaceComponent,
    CampPlaceDetailsComponent,
    CampPlaceCardComponent,
    CampPlaceListComponent,
    PagingHeaderComponent,
    CampPlaceTableComponent
  
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgxDropzoneModule,
    HttpClientModule,
    EventDetailsModule,
    BrowserAnimationsModule,
    CarouselModule,
    MatChipsModule,
    MatMenuModule,
    MatIconModule,
    NgxPaginationModule,
    MatTableModule



  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
