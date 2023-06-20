export class Product
{
  idProduct: number;
  name: string;
  description: string;
  state: string;
  price: number;
  available: boolean;
  size: number;
  weight: number;
  color: string;
category: any;
  constructor(  idProduct: number, name: string, description: string, state: string, price: number, available: boolean, size: number,weight: number, color: string ){

  this.idProduct= idProduct;
  this.name= name;
  this.description= description;
  this.state= state;
  this.price= price;
  this.available= available;
  this.size= size;
  this.weight= weight;
  this.color= color;


  }

}
