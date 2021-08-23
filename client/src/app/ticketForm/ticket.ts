export class Ticket{
    constructor(
        public amount:number,
        public type:string,
        public description:string,
        public status:string
    ){}
}