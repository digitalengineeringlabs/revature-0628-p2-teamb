import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { TicketComponent } from './ticket/ticket.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'tickets', component: TicketComponent},
  {path: '', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
