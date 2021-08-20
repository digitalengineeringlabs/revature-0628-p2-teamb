import { Component, OnInit } from "@angular/core"; 
import { HttpClient } from "@angular/common/http";
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private http:HttpClient, private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(form:NgForm) {
    // this.http.get('http://localhost:8080/login').subscribe({
    //   next: (data) => {
    //     console.log(data);
    //   }
    // })
    
    console.log(JSON.stringify({email:form.value.email, password:form.value.password}))
    this.http.post('http://localhost:8080/login', {email:form.value.email, password:form.value.password})
      .subscribe({
        next: (data) => {
            console.log(data);
        }
      })
  }

}
