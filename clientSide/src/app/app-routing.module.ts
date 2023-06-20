import { Injectable,NgModule } from '@angular/core';
import { RouterModule, Routes, TitleStrategy, RouterStateSnapshot } from '@angular/router';
<<<<<<< HEAD
import { AddEventComponent } from './Components/product/add-product/add-product.component';
import { EventDetailsComponent } from './Components/product/product-details/product-details.component';
=======
import { AddEventComponent } from './Components/event/add-event/add-event.component';
import { EventDetailsComponent } from './Components/event/event-details/event-details.component';
>>>>>>> origin/main
import { HomeComponent } from './Components/home/home.component';

const routes: Routes = [
  {path: "", component: HomeComponent},
<<<<<<< HEAD
  {path: "addproduct", component: AddEventComponent},
  {path: "ProductDetails", component: EventDetailsComponent},
=======
  {path: "addEvent", component: AddEventComponent},
  {path: "EventDetails", component: EventDetailsComponent},
>>>>>>> origin/main


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
