import {ComponentFixture, TestBed} from '@angular/core/testing';

import {ListeMissionApprenantComponent} from './liste-mission-apprenant.component';

describe('ListeMissionApprenantComponent', () => {
  let component: ListeMissionApprenantComponent;
  let fixture: ComponentFixture<ListeMissionApprenantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListeMissionApprenantComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(ListeMissionApprenantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
