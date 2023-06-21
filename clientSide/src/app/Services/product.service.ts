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

   return  this.httpClient.post(this.apiurl + 'product', this.convertProductToFormData(product,file)) ;

  }
  convertProductToFormData(product: Product, file: File): any {
    const formData = new FormData();
    formData.append('name', product.name);
    formData.append('description', product.description);
    formData.append('size', product.size.toString());
    formData.append('weight', product.weight.toString());
    formData.append('color', product.color);
    formData.append('category', product.category.toString());
    formData.append('image', file, file.name);
    return formData;
  }

  getAllProduct(){
    return this.httpClient.get<Product[]>(this.apiurl+'product');
  }



}
