import { Injectable,NgModule } from '@angular/core';
import { RouterModule, Routes, TitleStrategy, RouterStateSnapshot } from '@angular/router';
import { AddEventComponent } from './Components/product/add-product/add-product.component';
import { EventDetailsComponent } from './Components/product/product-details/product-details.component';
import { HomeComponent } from './Components/home/home.component';

const routes: Routes = [
  {path: "", component: HomeComponent},
  {path: "addproduct", component: AddEventComponent},
  {path: "ProductDetails", component: EventDetailsComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
