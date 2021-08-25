import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-ticket-view',
  templateUrl: './employee-ticket-view.component.html',
  styleUrls: ['./employee-ticket-view.component.css']
})
export class EmployeeTicketViewComponent implements OnInit {
  
  requests:EmployeeTicketView[] = [];
  filter:string = "none";

  constructor(private http:HttpClient, private router:Router) {}
  
  ngOnInit(): void {
    this.getEmployeeTickets();
  }

  getEmployeeTickets(){
    this.http.post('http://localhost:8080/getmytickets', {id:Number(localStorage.getItem("id"))}).subscribe({
      next: (data:any) => {
        console.log(data);
        //this.employeeTickets = response;
        this.requests = data;
      }
    });
  }

  filtering(form:NgForm) {
    console.log(form.value.statusFilter);
    this.filter = form.value.statusFilter;
  }


  formatDate(date:any) {
    let d = new Date(date);
    return d.getMonth() + "/" + d.getDate() + "/" + d.getFullYear();
  }
}


export class EmployeeTicketView {
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