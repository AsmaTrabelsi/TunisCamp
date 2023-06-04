import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-animated-card',
  templateUrl: './animated-card.component.html',
  styleUrls: ['./animated-card.component.css']
})
export class AnimatedCardComponent {

  @Input() imageSrc!: string;
}
