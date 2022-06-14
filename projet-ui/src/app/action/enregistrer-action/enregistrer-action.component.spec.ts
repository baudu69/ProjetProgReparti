import {ComponentFixture, TestBed} from '@angular/core/testing';

import {EnregistrerActionComponent} from './enregistrer-action.component';

describe('EnregistrerActionComponent', () => {
  let component: EnregistrerActionComponent;
  let fixture: ComponentFixture<EnregistrerActionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EnregistrerActionComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(EnregistrerActionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
