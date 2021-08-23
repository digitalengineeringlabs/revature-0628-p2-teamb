import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';


export class Ticket {
  constructor(
    public id: number,
    public amount: number,
    public description: string,
    public status: string,
    public time: Date,
    public type: string,
    public employee_id: number
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

  constructor(
    private httpClient: HttpClient
  ) { }

  ngOnInit(): void {
    this.getTickets();
  }

  getTickets(){
    this.httpClient.get<any>('http://localhost:9001/tickets').subscribe(
      response => {
        console.log(response);
        this.tickets = response;
      }
    );
  }

}
