import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeTicketView, EmployeeTicketViewComponent } from './employee-ticket-view/employee-ticket-view.component';
import { Ticket, TicketComponent } from './ticket/ticket.component';
import { newTicket } from './ticketForm/ticketForm.component';
import { ShowTicket } from './showTicket/showTicket';
const routes: Routes = [
  { path:'ticket', component: newTicket}, 
  { path: 'tickets', component: Ticket},
  { path: 'financeManager', component: TicketComponent},
  { path: 'employeeTicketView', component: EmployeeTicketViewComponent,
    children: [
      {path: 'view/:currentid', component: ShowTicket}
    ]},
  { path: 'showticket', component: ShowTicket},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [newTicket, ShowTicket];
