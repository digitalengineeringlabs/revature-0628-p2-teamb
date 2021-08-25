import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeTicketView, EmployeeTicketViewComponent } from './employee-ticket-view/employee-ticket-view.component';
import { Ticket } from './ticket/ticket.component';
import { newTicket } from './ticketForm/ticketForm.component';

const routes: Routes = [
  { path:'ticket', component: newTicket}, 
  { path: 'tickets', component: Ticket},
  { path: 'employeeTicketView', component: EmployeeTicketViewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [newTicket];
