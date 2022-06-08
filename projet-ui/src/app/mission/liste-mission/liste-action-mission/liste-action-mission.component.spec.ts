import {ComponentFixture, TestBed} from '@angular/core/testing';

import {ListeActionMissionComponent} from './liste-action-mission.component';

describe('ListeActionMissionComponent', () => {
  let component: ListeActionMissionComponent;
  let fixture: ComponentFixture<ListeActionMissionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListeActionMissionComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(ListeActionMissionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
