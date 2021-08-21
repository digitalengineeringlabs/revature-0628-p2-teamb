import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { newTicket } from './ticketForm/ticketForm.component';

const routes: Routes = [
  { path:'ticket', component: newTicket}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [newTicket];
