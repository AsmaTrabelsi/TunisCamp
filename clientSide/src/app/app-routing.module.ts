import { Injectable,NgModule } from '@angular/core';
import { RouterModule, Routes, TitleStrategy, RouterStateSnapshot } from '@angular/router';
import { AddEventComponent } from './Components/event/add-event/add-event.component';
import { EventCardComponent } from './Components/event/event-card/event-card.component';
import { EventDetailsComponent } from './Components/event/event-details/event-details.component';
import { FeedbackComponent } from './Components/feedback/feedback.component';
import { HomeComponent } from './Components/home/home.component';
import { ReservationComponent } from './Components/Reservation/reservation.component';

const routes: Routes = [
  {path: "", component: HomeComponent},
  {path: "addEvent", component: AddEventComponent},
  {path: "event", component: EventCardComponent},
  {path: "EventDetails", component: EventDetailsComponent},
  {path: "feedback", component: FeedbackComponent},
  {path: "reservation", component: ReservationComponent},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
