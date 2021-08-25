import { Component, Input, OnInit } from "@angular/core"; 
import { HttpClient } from "@angular/common/http";
import { Router, ActivatedRoute } from "@angular/router";


@Component({
  selector: 'app-login',
  templateUrl: './showTicket.html'
})
export class ShowTicket implements OnInit {

    ticket = {};

    constructor(private http:HttpClient, private route:ActivatedRoute, 
        private router:Router) { 
            
        }

    ngOnInit() {
        //this.ticket = this.router.getCurrentNavigation()?.extras.state;
    }
  

}