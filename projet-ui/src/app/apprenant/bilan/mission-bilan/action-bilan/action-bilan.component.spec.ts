import {ComponentFixture, TestBed} from '@angular/core/testing';

import {ActionBilanComponent} from './action-bilan.component';

describe('ActionBilanComponent', () => {
  let component: ActionBilanComponent;
  let fixture: ComponentFixture<ActionBilanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ActionBilanComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(ActionBilanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
