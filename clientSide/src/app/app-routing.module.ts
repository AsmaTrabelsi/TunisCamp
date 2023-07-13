import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';
import { AddEventComponent } from './Components/event/add-event/add-event.component';
import { EventDetailsComponent } from './Components/event/event-details/event-details.component';
import { EventListComponent } from './Components/event/event-list/event-list.component';
import { HomeComponent } from './Components/home/home.component';

import { AddProductComponent } from './Components/product/add-product/add-product.component';
import { ProductDetailsComponent } from './Components/product/product-details/product-details.component';
import { ProductCardComponent } from './Components/product/product-card/product-card.component';
import { ListProductComponent } from './Components/product/list-product/list-product.component';

import { NotFoundComponent } from './Components/not-found/not-found.component';
import { AddCampPlaceComponent } from './Components/campPlace/add-camp-place/add-camp-place.component';
import { CampPlaceDetailsComponent } from './Components/campPlace/camp-place-details/camp-place-details.component';
import { CampPlaceListComponent } from './Components/campPlace/camp-place-list/camp-place-list.component';


const routes: Routes = [
  {path: "", component: HomeComponent},

  {path: "addproduct", component: AddProductComponent},
  {path: "addEvent", component: AddEventComponent},
  {path: "EventDetails/:idEvent", component: EventDetailsComponent},
  {path: "EventList", component: EventListComponent},
  {path: "ProductDetails/:idProduct", component: ProductDetailsComponent},

  {path: "ProductCard", component: ProductCardComponent},
  {path: "ProductList", component: ListProductComponent},


  {path: "AddCampPlace", component: AddCampPlaceComponent},
  {path: "CampPlaceDetails/:idCampPlace", component: CampPlaceDetailsComponent},
  {path: "listCampPlace", component: CampPlaceListComponent},




  {path: "**", component: NotFoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
