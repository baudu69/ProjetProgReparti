import {ComponentFixture, TestBed} from '@angular/core/testing';

import {ListeIndicatorsComponent} from './liste-indicators.component';

describe('ListeIndicatorsComponent', () => {
  let component: ListeIndicatorsComponent;
  let fixture: ComponentFixture<ListeIndicatorsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListeIndicatorsComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(ListeIndicatorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
