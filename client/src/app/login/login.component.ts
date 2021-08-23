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

  invalid:boolean = false;

  constructor(private http:HttpClient, private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(form:NgForm) {
    console.log(JSON.stringify({email:form.value.email, password:form.value.password}))
    this.http.post('http://localhost:8080/login', {email:form.value.email, password:form.value.password, something:"hello"})
      .subscribe({
        next: (data) => {
            if(data != null) {
              localStorage.setItem("employee", JSON.stringify(data));
              this.router.navigate(['home']);
            } else {
              this.invalid = true;
            }
        }
      })
  }

}
