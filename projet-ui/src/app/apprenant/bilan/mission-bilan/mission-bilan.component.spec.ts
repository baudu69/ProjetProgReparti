import {ComponentFixture, TestBed} from '@angular/core/testing';

import {MissionBilanComponent} from './mission-bilan.component';

describe('MissionBilanComponent', () => {
  let component: MissionBilanComponent;
  let fixture: ComponentFixture<MissionBilanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MissionBilanComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(MissionBilanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
