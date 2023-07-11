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

   addProduct(product: Product, files:File[]) {
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'multipart/form-data');

   return  this.httpClient.post(this.apiurl + 'product/addProduct', this.convertProductToFormData(product,files)) ;

  }
  convertProductToFormData(product: Product, files: File[]): any {
    const formData = new FormData();
    formData.append('name', product.name);
    formData.append('description', product.description);
    formData.append('size', product.size.toString());
    formData.append('weight', product.weight.toString());
    formData.append('color', product.color);
    formData.append('category', product.category.toString());
    formData.append('state', product.state.toString());

    for (let i = 0; i < files.length; i++) {
      formData.append('files[' + i + ']', files[i], files[i].name);

    }
    return formData;
  }

  getAllProduct(){
    return this.httpClient.get<Product[]>(this.apiurl+'product');
  }



}
