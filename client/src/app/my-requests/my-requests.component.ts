import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-requests',
  templateUrl: './my-requests.component.html',
  styleUrls: ['./my-requests.component.css']
})
export class MyRequestsComponent implements OnInit {

  requests:request[] = [];

  constructor(private http:HttpClient, private router:Router) { }

  ngOnInit(): void {
    this.http.post('http://localhost:8080/getmytickets', {id:Number(localStorage.getItem("id"))})
    .subscribe({
      next: (data:any) => {
        if(data !== null) {
          console.log(data);
          for(let d of data) {
            this.requests.push(new request(d.id, d.type, d.description, d.amount, d.time, d.status));
          }
        }
      }
    })
  }

  formatDate(date:any) {
    let d = new Date(date);
    return d.getMonth() + "/" + d.getDate() + "/" + d.getFullYear();
  }
}

export class request {
    id:number
    type:string
    description:string
    amount:number
    time:Date
    status:string
  
    constructor(
      id:number,
      type:string,
      description:string,
      amount:number,
      time:Date,
      status:string
    ) {
      this.id = id;
      this.type = type;
      this.description = description;
      this.amount = amount;
      this.time = time;
      this.status = status;
    }
}
