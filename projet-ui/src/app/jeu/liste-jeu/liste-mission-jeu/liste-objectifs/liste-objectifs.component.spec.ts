import {ComponentFixture, TestBed} from '@angular/core/testing';

import {ListeObjectifsComponent} from './liste-objectifs.component';

describe('ListeObjectifsComponent', () => {
  let component: ListeObjectifsComponent;
  let fixture: ComponentFixture<ListeObjectifsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListeObjectifsComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(ListeObjectifsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
