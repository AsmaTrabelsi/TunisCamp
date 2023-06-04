export class Event{

    idEvent? : number;
    name : string;
    description : string;
    startDate : Date;
    endDate : Date;
    nbParticipant : number;
    image : string;
    price: number;

    constructor(name: string, des: string, startDate: Date, endDate: Date, nbP: number, img: string,price: number, id?: number) {
        this.idEvent = id;
        this.name = name;
        this.description = des;
        this.startDate = startDate;
        this.endDate = endDate;
        this.image = img;
        this.nbParticipant = nbP;
        this.price= price;
      }
      

}