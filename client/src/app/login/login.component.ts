import { Component, OnInit } from "@angular/core"; 
import { HttpClient } from "@angular/common/http";
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";
import { environment } from "src/environments/environment";


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
    this.http.post(environment.loginUrl, {email:form.value.email, password:form.value.password})
      .subscribe({
        next: (data:any) => {
            if(data != null) {
              localStorage.setItem("id", data.id);
              localStorage.setItem("role", data.role);
              this.router.navigate(['home']);
            } else {
              this.invalid = true;
            }
        }
      })
  }

}
