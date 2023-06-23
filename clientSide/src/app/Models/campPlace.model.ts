export class CampPlace {

    idCampPlace? : number ;
    name :  string;
    category : string ;
    tel : number;
    email : string ;
    address : string ;
    state : string;

constructor(name: string,category: string, tel : number,email: string,address: string,state : string, idCampPlace? : number){

    this.idCampPlace = idCampPlace;
    this.name = name;
    this.address= address;
    this.category = category;
    this.tel = tel;
    this.email= email;
    this.state= state;

}   
  }