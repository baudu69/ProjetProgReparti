import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeMissionJeuComponent } from './liste-mission-jeu.component';

describe('ListeMissionJeuComponent', () => {
  let component: ListeMissionJeuComponent;
  let fixture: ComponentFixture<ListeMissionJeuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeMissionJeuComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListeMissionJeuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
