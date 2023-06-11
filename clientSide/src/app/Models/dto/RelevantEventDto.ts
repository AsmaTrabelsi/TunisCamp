export class RelevantEvent{
    idEvent: number;
    name:string;

  campPlaceLocation: string;
  constructor(idEvent:number,name:string,campPlaceLocation:string){
    this.idEvent=idEvent;
    this.name=name;
    this.campPlaceLocation=campPlaceLocation;
  }
}
