import { Component, Directive, ElementRef, HostListener, OnInit } from '@angular/core';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import { EventService } from 'app/Services/event.service';
import { OwlOptions } from 'ngx-owl-carousel-o';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent  implements OnInit {
  events : any;
  public imageData: any;
  reader :FileReader= new FileReader();

  constructor(private eventServive : EventService,private sanitizer: DomSanitizer){

  }
  ngOnInit(): void {
    this.eventServive.getAllEvent().subscribe(
      reponse =>{
        console.log(reponse);

        this.events = reponse;
        console.log(this.events[0].image);
        this.imageData = 'data:image/jpeg;base64,' + this.events[2].image;


      },
      error=>{
        console.log("eroor"+error);
      }
    )
  }
  partnerLogos: string[] = [
    'assets/partner/tino.png',
    'assets/partner/traveltodo.png',
    'assets/partner/voyage.png',
    'assets/partner/lastminute.png',
    'assets/partner/ctrip.jpg',
    'assets/partner/itaka.png',
  ];

  customOptions2: OwlOptions = {
    items: 6, loop: true, autoplay: true, autoplayTimeout: 2000,
    mouseDrag: false,
    touchDrag: false,
    pullDrag: false,
    dots: false,
    navSpeed: 700,
    navText: ['', ''],
    responsive: {
      0: {
        items: 1
      },
      400: {
        items: 2
      },
      740: {
        items: 3
      },
      940: {
        items: 4
      }
    },
    nav: true
  }
  customOptions: OwlOptions = {
    loop: true,
    mouseDrag: false,
    touchDrag: false,
    pullDrag: false,
    dots: false,
    navSpeed: 700,
    navText: ['', ''],
    responsive: {
      0: {
        items: 1
      },
      400: {
        items: 2
      },
      740: {
        items: 3
      },
      940: {
        items: 4
      }
    },
    nav: true
  }
}
