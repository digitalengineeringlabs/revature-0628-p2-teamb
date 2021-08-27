import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { TutorialService } from 'src/app/services/tutorial.service';


const baseUrl = 'http://localhost:8080/api/tutorials';

export class Ticket {
    id?: number;
    amount?: number;
    description?: string;
    status?: string;
    time?: Date;
    type?: string;
    employee_id?: number;
}

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {

  tickets?: Ticket[];
  currentTutorial: Ticket = {};
  currentIndex = -1;
  title = '';
  message = '';

  constructor(private httpClient: HttpClient,private http: HttpClient,private tutorialService: TutorialService) { }

  ngOnInit(): void {
    this.message = '';
    this.getTickets();
  }

  getTickets(){
    this.httpClient.get<any>('http://localhost:8080/api/Alltickets').subscribe(
      response => {
        console.log(response);
        this.tickets = response;
      }
    );
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  setActiveTutorial(tutorial: Ticket, index: number): void {
    this.currentTutorial = tutorial;
    this.currentIndex = index;
  }

  updateApproved(status2: any){
    const data = {
      amount: this.currentTutorial.amount,
      description: this.currentTutorial.description,
      time: this.currentTutorial.time,
      type: this.currentTutorial.type,
      employee_id: this.currentTutorial.employee_id,
      id: this.currentTutorial.id,
      
      status: status2='approved' 
    };

    this.message = '';
    console.log(data);
    this.tutorialService.update(this.currentTutorial.id, data)
    .subscribe(
      response => {
          this.currentTutorial.status = 'approved';
          console.log(response);
          this.message = response.message ? response.message : 'The riembursement was edited successfully!';
        },
        error => {
          console.log(error);
        });
  }

}
