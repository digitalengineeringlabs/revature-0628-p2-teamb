import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { TicketComponent } from './ticket/ticket.component';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from './auth.guard';
import { NavbarComponent } from './navbar/navbar.component';

const routes:Routes = [
  {path: '', component: HomeComponent, canActivate:[AuthGuard]},
  {path: 'home', component:HomeComponent, canActivate:[AuthGuard]},
  {path: 'login', component: LoginComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    routingComponents,
    NavbarComponent,
    TicketComponent
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


