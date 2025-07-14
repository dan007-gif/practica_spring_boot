import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValidarFechaComponent } from './validar-fecha';

describe('ValidarFechaComponent', () => {
  let component: ValidarFechaComponent;
  let fixture: ComponentFixture<ValidarFechaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ValidarFechaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ValidarFechaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
