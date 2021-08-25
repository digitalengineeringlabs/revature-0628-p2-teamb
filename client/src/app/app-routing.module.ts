import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { newTicket } from './ticketForm/ticketForm.component';
import { TicketComponent } from './ticket/ticket.component';
import { ShowTicket } from './showTicket/showTicket';
const routes: Routes = [
  { path:'ticket', component: newTicket},
  {path: 'tickets', component: TicketComponent,
  children: [
    { path: ':id', component: ShowTicket}
  ]}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [newTicket];
