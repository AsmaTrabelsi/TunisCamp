import { formatDate } from '@angular/common';
import { HttpClient, HttpHeaders  } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Event } from '../Models/event';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  apiurl ="http://localhost:9090/";

  constructor(private httpClient: HttpClient){

  }


  addEvent(event: Event, file:File) {
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'multipart/form-data');

   return  this.httpClient.post(this.apiurl + 'event', this.convertEventToFormData(event,file)) ;

   // return this.httpClient.post(`${this.apiurl}event`, event, { headers });
  }


  getAllEvent(){
    return this.httpClient.get(this.apiurl+'event');
  }

  convertEventToFormData(event: Event, file:File): FormData{
    const formData = new FormData();
    formData.append('name', event.name);
    formData.append('description', event.description);
    formData.append('startDate', formatDate(event.startDate, 'yyyy-MM-dd', 'en-US'));
    formData.append('endDate', formatDate(event.endDate, 'yyyy-MM-dd', 'en-US'));
    formData.append('nbParticipant', event.nbParticipant.toString());
    formData.append('image', file, file.name);
    return formData;
  }
}
