
export class Event{

    idEvent? : number;
    name : string;
    description : string;
    startDate : Date;
    endDate : Date;
    nbParticipant : number;
    image? : any;
    price: number;
    category: string;

    constructor(name: string, des: string, startDate: Date, endDate: Date, nbP: number,price: number,cate: string, id?: number,img?: any) {
        this.idEvent = id;
        this.name = name;
        this.description = des;
        this.startDate = startDate;
        this.endDate = endDate;
        this.nbParticipant = nbP;
        this.price= price;
        this.category=cate;
      }


}
