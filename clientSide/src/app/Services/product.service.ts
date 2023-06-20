import { Injectable } from "@angular/core";
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Product} from "../Models/Product.model";

@Injectable({
  providedIn: 'root'
})
export class productservice {

getProductCategories(){
    return this.httpClient.get<string[]>(this.apiurl+'product/categories');

  }
  apiurl ="http://localhost:9090/";


  constructor(private httpClient: HttpClient) {

   }

   addProduct(product: Product, file:File) {
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'multipart/form-data');

   return  this.httpClient.post(this.apiurl + 'event', this.convertEventToFormData(product,file)) ;

  }
  convertEventToFormData(product: Product, file: File): any {
    throw new Error("Method not implemented.");
  }

  getAllProduct(){
    return this.httpClient.get<Product[]>(this.apiurl+'product');
  }



}
