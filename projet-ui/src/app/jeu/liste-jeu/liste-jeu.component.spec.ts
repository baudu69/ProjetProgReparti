import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeJeuComponent } from './liste-jeu.component';

describe('ListeJeuComponent', () => {
  let component: ListeJeuComponent;
  let fixture: ComponentFixture<ListeJeuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeJeuComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListeJeuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
