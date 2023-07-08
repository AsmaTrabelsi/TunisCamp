import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-camp-place-card',
  templateUrl: './camp-place-card.component.html',
  styleUrls: ['./camp-place-card.component.css']
})
export class CampPlaceCardComponent {
 @Input() campPlace: any;
 
}
