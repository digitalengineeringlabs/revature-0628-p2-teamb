import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeTicketViewComponent } from './employee-ticket-view.component';

describe('EmployeeTicketViewComponent', () => {
  let component: EmployeeTicketViewComponent;
  let fixture: ComponentFixture<EmployeeTicketViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeTicketViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeTicketViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
