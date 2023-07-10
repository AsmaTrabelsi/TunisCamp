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
  destinations:{name:string,img:string}[]=[
    {name:"Tbarka",img:"assets/tbarka.jpg"},
    {name:"Zaghoun",img:"assets/zaghouan.jpg"},
    {name:"Tbarka",img:"assets/tbarka.jpg"},
    {name:"Zaghoun",img:"assets/zaghouan.jpg"},
    {name:"Zaghoun",img:"assets/zaghouan.jpg"}

  ];

      // camp place a supprime
      imageList: string[] = [
        'assets/zaghouan.jpg',
        'assets/bg.png',
        'assets/bg3.jpg',
        'assets/tbarka.jpg',
        // Add more images to the list
      ];
      selectedCampImage = 'assets/zaghouan.jpg';

      selectImage(image: string) {
        this.selectedCampImage = image;
      }



  equipements :Equipement[]=[
    {name:"Automatic Tent For Beach And Camping",description:"Automatic tent for beach and camping 8 places 250*250*165 cm This pop-up beach tent opens automatically in seconds, no assembly required. very easy to fold up into a small round shape and put in the carry bag.",
    state:"new",price:250,category:"Beach And Camping",images:["https://tn.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/68/1271/1.jpg?4466","https://contents.mediadecathlon.com/p1259581/k$47977d533ae46915ab592bab64ec7153/tente-de-camping-2-seconds-verte-3-personnes.jpg?format=auto&quality=60&f=452x452",
    "https://www.lidl.fr/assets/gcpc6867a05209246f2bd0ab39f90668e7e.jpeg"],url:"https://www.lidl.fr/assets/gcpc6867a05209246f2bd0ab39f90668e7e.jpeg"},
    {name:"Chaise de camping plage pliante - Fauteuil pliable",description:"Automatic tent for beach and camping 8 places 250*250*165 cm This pop-up beach tent opens automatically in seconds, no assembly required. very easy to fold up into a small round shape and put in the carry bag.",
    state:"new",price:50,category:"Beach And Camping",images:["https://tn.jumia.is/unsafe/fit-in/500x500/filters:fill(white)/product/45/9344/1.jpg?7547","https://tn.jumia.is/unsafe/fit-in/500x500/filters:fill(white)/product/75/9344/1.jpg?7546",
    "https://tn.jumia.is/unsafe/fit-in/500x500/filters:fill(white)/product/14/9716/1.jpg?9651"],url:"https://tn.jumia.is/unsafe/fit-in/500x500/filters:fill(white)/product/14/9716/1.jpg?9651"},
    {name:"Automatic Tent For Beach And Camping",description:"Automatic tent for beach and camping 8 places 250*250*165 cm This pop-up beach tent opens automatically in seconds, no assembly required. very easy to fold up into a small round shape and put in the carry bag.",
    state:"new",price:250,category:"Beach And Camping",images:["https://tn.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/68/1271/1.jpg?4466","https://contents.mediadecathlon.com/p1259581/k$47977d533ae46915ab592bab64ec7153/tente-de-camping-2-seconds-verte-3-personnes.jpg?format=auto&quality=60&f=452x452",
    "https://www.lidl.fr/assets/gcpc6867a05209246f2bd0ab39f90668e7e.jpeg"],url:"https://www.lidl.fr/assets/gcpc6867a05209246f2bd0ab39f90668e7e.jpeg"},
    {name:"Automatic Tent For Beach And Camping",description:"Automatic tent for beach and camping 8 places 250*250*165 cm This pop-up beach tent opens automatically in seconds, no assembly required. very easy to fold up into a small round shape and put in the carry bag.",
    state:"new",price:250,category:"Beach And Camping",images:["https://tn.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/68/1271/1.jpg?4466","https://contents.mediadecathlon.com/p1259581/k$47977d533ae46915ab592bab64ec7153/tente-de-camping-2-seconds-verte-3-personnes.jpg?format=auto&quality=60&f=452x452",
    "https://www.lidl.fr/assets/gcpc6867a05209246f2bd0ab39f90668e7e.jpeg"],url:"https://www.lidl.fr/assets/gcpc6867a05209246f2bd0ab39f90668e7e.jpeg"},
  ]

  constructor(private eventServive : EventService,private sanitizer: DomSanitizer){

  }
  ngOnInit(): void {
    this.eventServive.getAllEvent().subscribe(
      reponse =>{
        console.log(reponse);

        this.events = reponse;
      },
      error=>{
        console.log("error"+error);
      }
    )
  }
  partnerLogos: string[] = [
    'assets/partner/ctrip.png',
    'assets/partner/traveltodo.png',
    'assets/partner/tui.png',
    'assets/partner/diammant.png',
    'assets/partner/voyage.png',
    'assets/partner/itaka.png',
    'assets/partner/paximum.png',
    'assets/partner/clickNgo.png'
  ];

  PartnersOptions: OwlOptions = {
    items: this.partnerLogos.length,
    loop: true,
    autoplay: true,
    autoplayTimeout: 2000,
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
        items: 5
      }
    },
    nav: false
  }
  eventOptions: OwlOptions = {
    loop: false,
    mouseDrag: true,
    touchDrag: true,
    pullDrag: true,
    dots: false,
    navSpeed: 700,
    navText: ['<i class="bi bi-caret-left-fill"></i>', '<i class="bi bi-caret-right-fill"></i>'],
    responsive: {
      0: {
        items: 1
      },
      500: {
        items: 2
      },
      740: {
        items: 2
      },
      940: {
        items: 3
      }
    },
    nav: true
  }
  imageChange(equipment: Equipement, index: number) {
    equipment.url = equipment.images[index];
  }
}

export class Equipement{
  constructor(public name:string, public description:string,public state:string, public price:number,
    public category:string,public url:string, public images:string[]){

    }





}
