import { Injectable,NgModule } from '@angular/core';
import { RouterModule, Routes, TitleStrategy, RouterStateSnapshot } from '@angular/router';
import { AddEventComponent } from './Components/event/add-event/add-event.component';
import { EventDetailsComponent } from './Components/event/event-details/event-details.component';
import { HomeComponent } from './Components/home/home.component';
import { NotFoundComponent } from './Components/not-found/not-found.component';
import { AddCampPlaceComponent } from './Components/campPlace/add-camp-place/add-camp-place.component';
import { CampPlaceDetailsComponent } from './Components/campPlace/camp-place-details/camp-place-details.component';
import { CampPlaceListComponent } from './Components/campPlace/camp-place-list/camp-place-list.component';
import { CampPlaceTableComponent } from './Components/campPlace/camp-place-table/camp-place-table.component';

const routes: Routes = [
  {path: "", component: HomeComponent},
  {path: "addEvent", component: AddEventComponent},
  {path: "EventDetails", component: EventDetailsComponent},
  {path: "AddCampPlace", component: AddCampPlaceComponent},
  {path: "CampPlaceDetails/:idCampPlace", component: CampPlaceDetailsComponent},
  {path: "listCampPlace", component: CampPlaceListComponent},
  {path: "CampPlaceTable", component: CampPlaceTableComponent},




  {path: "**", component: NotFoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
