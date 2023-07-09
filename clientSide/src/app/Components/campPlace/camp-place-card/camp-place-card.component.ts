import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-camp-place-card',
  templateUrl: './camp-place-card.component.html',
  styleUrls: ['./camp-place-card.component.css']
})
export class  CampPlaceCardComponent implements OnInit{
 ngOnInit(): void {

  console.log(this.campPlace.img);
 }
 @Input() campPlace: any;
 
}
