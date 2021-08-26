import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8080/tutorials';

export class Ticket {
  constructor(
    public id?: number,
    public amount?: number,
    public description?: string,
    public status?: string,
    public time?: Date,
    public type?: string,
    public employee_id?: number
  ) {
  }
}

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {

  tickets: Ticket[] | undefined;
  currentTutorial: Ticket = {};


  constructor(
    private httpClient: HttpClient,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getTickets();
  }

  getTickets(){
    this.httpClient.get<any>('http://localhost:8080/Alltickets').subscribe(
      response => {
        console.log(response);
        this.tickets = response;
      }
    );
  }

  update(id: any, data: any): Observable<any> {
    return this.httpClient.put(`${baseUrl}/${id}`, data);
  }

  updateApproved(status2: any){
    const data = {
      description: this.currentTutorial.description,
      status: status2='approved' 
    };
    console.log(data);
    this.update(this.currentTutorial.id, data)
    .subscribe(
      response => {
          this.currentTutorial.status = 'approved';
          console.log(response);
       
        },
        error => {
          console.log(error);
        });
  }

}


