import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Product } from 'app/Models/Product.model';
import { productservice } from 'app/Services/product.service';


@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit{
  files: File[] = [];
  selectedCategory : any;
  product: Product = new Product(1, "", "", "", 1,false, 1,1, "");

  categories :string[]=[];

  constructor(private productService: productservice){

  }
  ngOnInit(): void {
    this.productService.getProductCategories().subscribe(
      response =>{

        this.categories = response
      },
      error =>{
        console.log(error);
      }
    )
  }


  addProduct(productNgForm: NgForm){
    if (productNgForm.valid == false || this.files.length < 1) {
      console.log(productNgForm.errors);
      return;
    }
    console.log(this.selectedCategory);
    console.log(this.product);
    this.productService.addProduct(this.product, this.files[0]).subscribe(
      reponse =>{
        console.log('Product added successfully');

        /*Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Your product has been saved',
          showConfirmButton: false,
          timer: 2500
        });
        */

        productNgForm.resetForm();
        this.files = [];
      },

      error=>{
        console.log(error);

        /*
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Something went wrong! Unable to upload image',
        });
        */
      }
    );
  }


	onSelect(product: any) {
		console.log(product);
		this.files.push(...product.addedFiles);
	}

	onRemove(product: any) {
		console.log(product);
		this.files.splice(this.files.indexOf(product), 1);
	}

  formatCategoryName(category: string): string {
    const formatedCategory = category.toLowerCase().replaceAll('_'," ");
    return formatedCategory;
  }

}
