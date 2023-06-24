import { HttpClient, HttpHeaders  } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CampPlace } from 'app/Models/campPlace.model';

@Injectable({
  providedIn: 'root'
})
export class CampPlaceService {

  apiurl ="http://localhost:9090/";

  constructor(private httpClient: HttpClient){

  }


  addCampPlace(campPlace:CampPlace, file:File[]) {
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'multipart/form-data');

   return  this.httpClient.post(this.apiurl + 'campPlace', this.convertEventToFormData(campPlace,file)) ;

  }


  getAllCampPlace(){
    return this.httpClient.get<CampPlace[]>(this.apiurl+'campPlace');
  }
  getCampPlaceCategories(){
    return this.httpClient.get<string[]>(this.apiurl+'campPlace/categories');

  }
  getState(){
    return this.httpClient.get<string[]>(this.apiurl+'campPlace/state');

  }

  convertEventToFormData(campPlace: CampPlace, files:File[]): FormData{
    const formData = new FormData();
    formData.append('name', campPlace.name);
    formData.append('tel', campPlace.tel.toString());
    formData.append('email', campPlace.email);
    formData.append('address', campPlace.address);
    formData.append('category', campPlace.category)
    formData.append('state', campPlace.state);
    //formData.append('image', files[0], files[0].name);
    for (let i = 0; i < files.length; i++) {
      //formData.append('images', files[i], files[i].name);
      formData.append('images[' + i + ']', files[i], files[i].name);

    }
    console.log(formData);
    return formData;
  }
}
