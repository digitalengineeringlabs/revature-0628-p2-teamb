import { Inject, Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { EmployeeTicketView } from '../employee-ticket-view/employee-ticket-view.component';

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor() { }

  private date = new Date();
  private etv = new EmployeeTicketView(0,"","",0,this.date,"");
  private _ticket:EmployeeTicketView = this.etv;
  public bhs$ = new BehaviorSubject(this._ticket);

  

  public getScope():any {
      return this._ticket;
  }

  public setScope(ticket: EmployeeTicketView) {
      this._ticket = ticket;
  }
  
  public getBhs():any {
    return this.bhs$
  }
}
