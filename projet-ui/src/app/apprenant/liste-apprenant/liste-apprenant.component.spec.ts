import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeApprenantComponent } from './liste-apprenant.component';

describe('ListeApprenantComponent', () => {
  let component: ListeApprenantComponent;
  let fixture: ComponentFixture<ListeApprenantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeApprenantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeApprenantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
