export class campPlace {

    idCampPlace : number;
    name :  string;
    category : string ;
    tel : number;
    email : string ;
    address : string ;
    state : string;

constructor(idCampPlace : number ,name: string,category: string, tel : number,email: string,address: string,state : string){

    this.idCampPlace = idCampPlace;
    this.name = name;
    this.address= address;
    this.category = category;
    this.tel = tel;
    this.email= email;
    this.state= state;

}   
  }