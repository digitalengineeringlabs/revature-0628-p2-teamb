
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
    selector: 'newTicket',
    templateUrl: './ticketForm.component.html'
  })

  export class newTicket {
    
    constructor(private http:HttpClient, private router:Router) {}

//  This method still needs to be redone
    onSubmit(form:NgForm) {      
      console.log(form);
      this.http.post("http://localhost:8080/tickets/new", ({
        amount: form.value.amount,
        type: form.value.type,
        description: form.value.description,
        status: form.value.status,
        empId: Number(localStorage.getItem("id"))//form.value.empid
      }))
      .subscribe({
        next:(data:any)=>{
          console.log(data);
          this.router.navigate(['home']);
          
        },
        error:(error)=>{
          console.log(error);
        },
        complete:()=>{}
      })
    }
  }
//  Ticket model
  export class Ticket{
    constructor(
      protected type: string,
      protected desription: string,
      protected amount: number,
      protected status: string,
      protected empid: number,
      protected employee_id: number,
    ) {}
  }