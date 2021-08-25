import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

export class EmployeeTicketView {
  /*constructor(
    public id: number,
    public amount: number,
    public description: string,
    public status: string,
    public time: Date,
    public type: string,
    public employee_id: number
  ) {
  }*/
}

@Component({
  selector: 'app-employee-ticket-view',
  templateUrl: './employee-ticket-view.component.html',
  styleUrls: ['./employee-ticket-view.component.css']
})
export class EmployeeTicketViewComponent implements OnInit {
  
  constructor(private http:HttpClient, private router:Router) {}
  
  ngOnInit(): void {
    //this.getEmployeeTickets();
  }

/*
  getEmployeeTickets(){
    this.httpClient.get<any>('http://localhost:8080/employeeTicketView').subscribe(
      response => {
        console.log(response);
        //this.employeeTickets = response;
      }
    );
  }*/
}
