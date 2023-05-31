import { Injectable,NgModule } from '@angular/core';
import { RouterModule, Routes, TitleStrategy, RouterStateSnapshot } from '@angular/router';
import { AddEventComponent } from './Components/event/add-event/add-event.component';
import { HomeComponent } from './Components/home/home.component';

const routes: Routes = [
  {path: "", component: HomeComponent},
  {path: "addEvent", component: AddEventComponent},

  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
