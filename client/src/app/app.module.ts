import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from './auth.guard';
import { newTicket } from './ticketForm/ticketForm.component';
import { MyRequestsComponent } from './my-requests/my-requests.component';

const routes:Routes = [
  {path: '', component: HomeComponent, canActivate:[AuthGuard]},
  {path: 'home', component:HomeComponent, canActivate:[AuthGuard]},
  {path: 'ticketform', component:newTicket},
  {path: 'login', component: LoginComponent},
  {path: 'mytickets', component:MyRequestsComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    newTicket,
    routingComponents,
    MyRequestsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


