import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Event } from '../Models/event';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  apiurl ="http://localhost:9090/";

  constructor(private httpClient: HttpClient){

  }
  addEvent(event: Event) {
    return this.httpClient.post(`${this.apiurl}event`, event);
  }
}
