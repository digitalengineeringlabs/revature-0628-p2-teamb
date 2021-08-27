import { Component, Input, OnInit, ChangeDetectionStrategy, OnChanges, SimpleChanges, Inject } from "@angular/core"; 
import { HttpClient } from "@angular/common/http";
import { Router} from "@angular/router";
import { EmployeeTicketView, EmployeeTicketViewComponent } from "../employee-ticket-view/employee-ticket-view.component";
import { StorageService } from "./storage.service";


@Component({
  selector: 'showticket',
  templateUrl: './showTicket.html'
})
export class ShowTicket implements OnInit {

    
    teekit = this.service.bhs$.subscribe(_ticket => _ticket);
    ticket = this.service.getScope();

    constructor(protected http:HttpClient, protected router:Router,protected service: StorageService) {
       
    }
    
    ngOnInit() {

    }
    
    getScopeInfo() {
      console.log(this.service.getScope())
      this.ticket = this.service.getScope();
    }

}
