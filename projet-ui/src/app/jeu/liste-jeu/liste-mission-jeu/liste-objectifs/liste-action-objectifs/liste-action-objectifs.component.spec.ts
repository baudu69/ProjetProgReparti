import {ComponentFixture, TestBed} from '@angular/core/testing';

import {ListeActionObjectifsComponent} from './liste-action-objectifs.component';

describe('ListeActionObjectifsComponent', () => {
  let component: ListeActionObjectifsComponent;
  let fixture: ComponentFixture<ListeActionObjectifsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListeActionObjectifsComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(ListeActionObjectifsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
