import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Feedback } from "app/Models/feedback";



@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  apiurl ="http://localhost:9090/";

  constructor(private httpClient: HttpClient){
  }

  addFeedback(feedback: Feedback) {
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'multipart/form-data');

   return  this.httpClient.post(this.apiurl + 'feedback', feedback) ;

  }

}
