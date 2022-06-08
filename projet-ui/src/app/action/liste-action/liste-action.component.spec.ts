import {ComponentFixture, TestBed} from '@angular/core/testing';

import {ListeActionComponent} from './liste-action.component';

describe('ListeActionComponent', () => {
  let component: ListeActionComponent;
  let fixture: ComponentFixture<ListeActionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListeActionComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(ListeActionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
