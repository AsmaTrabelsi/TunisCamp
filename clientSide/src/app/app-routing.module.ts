import { Injectable,NgModule } from '@angular/core';
import { RouterModule, Routes, TitleStrategy, RouterStateSnapshot } from '@angular/router';
import { AddEventComponent } from './Components/event/add-event/add-event.component';
import { EventDetailsComponent } from './Components/event/event-details/event-details.component';
import { HomeComponent } from './Components/home/home.component';
import { AddProductComponent } from './Components/product/add-product/add-product.component';

const routes: Routes = [
  {path: "", component: HomeComponent},
  {path: "addproduct", component: AddProductComponent},
  {path: "ProductDetails", component: EventDetailsComponent},
  {path: "addEvent", component: AddEventComponent},
  {path: "EventDetails", component: EventDetailsComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
