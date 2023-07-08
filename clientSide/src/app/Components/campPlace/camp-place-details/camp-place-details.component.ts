import { Component } from '@angular/core';
import { CampPlace } from 'app/Models/campPlace.model';

@Component({
  selector: 'app-camp-place-details',
  templateUrl: './camp-place-details.component.html',
  styleUrls: ['./camp-place-details.component.css']
})
export class CampPlaceDetailsComponent {
  

  imageList: string[] = [

    'https://images.pexels.com/photos/16952091/pexels-photo-16952091/free-photo-of-wood-landscape-field-summer.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',

    'https://images.pexels.com/photos/13713058/pexels-photo-13713058.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',

    'https://images.pexels.com/photos/6732034/pexels-photo-6732034.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',

    'https://images.pexels.com/photos/9083457/pexels-photo-9083457.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',

    // Add more images to the list

  ];
  campPlace = new CampPlace('bni mtir','FORET',28315715,'aaaaa','aaaa','BEJA',this.imageList,"description du poste ",1,1);
  campPlaces:{name:string,img:string,state:string}[]=[

    {name:"Tbarka",img:"assets/tbarka.jpg",state:"state1"},

    {name:"Zaghoun",img:"assets/zaghouan.jpg",state:"state2"},

    {name:"Tbarka",img:"assets/tbarka.jpg", state: "state3"},

    {name:"Zaghoun",img:"assets/zaghouan.jpg", state :"state"},

 

  ];

  selectedCampImage = this.campPlace.images[0];


 selectImage(image: string) {

    this.selectedCampImage = image;
    

  }



}
