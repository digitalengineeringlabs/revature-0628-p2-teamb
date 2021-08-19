
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
    selector: 'login',
    templateUrl: './login.html'
  })

 
  export class Login {
    
    constructor(private http:HttpClient, private router:Router) {}

//  This method still needs to be redone
    onSubmit(form:NgForm) {      
      console.log(form);
      this.http.post("http://localhost:8080/Project1/user", JSON.stringify({username:form.value.username,employeeID:form.value.empid}))
      .subscribe({
        next:(data:any)=>{
          console.log(data);
          this.router.navigate(['/employee'])
          localStorage.setItem("username", form.value.username);
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
      protected employee_id: number,
      protected type: string,
      protected desription: string,
      protected amount: number,
      protected status: string
    ) {}
  }