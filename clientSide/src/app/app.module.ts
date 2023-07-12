import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './Shared/header/header.component';
import { FooterComponent } from './Shared/footer/footer.component';
import { NotFoundComponent } from './Components/not-found/not-found.component';
import { HomeComponent } from './Components/home/home.component';

import { AddProductComponent } from './Components/product/add-product/add-product.component';
import { FormsModule } from '@angular/forms';
import { NgxDropzoneModule } from 'ngx-dropzone';
import {HttpClientModule } from '@angular/common/http';
import { EventDetailsModule } from './Components/event/event-details/event-details.module';
import {MatButtonModule} from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CarouselModule } from 'ngx-owl-carousel-o';

import { ProductDetailsComponent } from './Components/product/product-details/product-details.component';
import { ProductCardComponent } from './Components/product/product-card/product-card.component';
import { ListProductComponent } from './Components/product/list-product/list-product.component';

import { NgxSliderModule } from '@angular-slider/ngx-slider';





import { AddCampPlaceComponent } from './Components/campPlace/add-camp-place/add-camp-place.component';
import { CampPlaceDetailsComponent } from './Components/campPlace/camp-place-details/camp-place-details.component';
import { CampPlaceCardComponent } from './Components/campPlace/camp-place-card/camp-place-card.component';
import { CampPlaceListComponent } from './Components/campPlace/camp-place-list/camp-place-list.component';
import {MatChipsModule} from '@angular/material/chips';
import { PagingHeaderComponent } from './Shared/paging-header/paging-header.component';
import {MatIconModule} from '@angular/material/icon';
import {MatMenuModule} from '@angular/material/menu';
import { NgxPaginationModule } from 'ngx-pagination';





@NgModule({
    declarations: [
        AppComponent,
        HeaderComponent,
        FooterComponent,
        NotFoundComponent,
        HomeComponent,
        AddProductComponent,
        ProductDetailsComponent,
        ProductCardComponent,
        ListProductComponent,
        AddCampPlaceComponent,
        CampPlaceDetailsComponent,
        CampPlaceCardComponent,
        CampPlaceListComponent,
        PagingHeaderComponent,
    ],
    providers: [],
    bootstrap: [AppComponent],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        NgxDropzoneModule,
        HttpClientModule,
        BrowserAnimationsModule,
        CarouselModule,
        MatChipsModule,
        NgxPaginationModule,
        MatButtonModule,
        MatMenuModule,
        MatIconModule,
        NgxSliderModule,
        NgxPaginationModule,
        EventDetailsModule
    ]
})
export class AppModule { }
