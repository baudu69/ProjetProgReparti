import {ComponentFixture, TestBed} from '@angular/core/testing';

import {SearchApprenantComponent} from './search-apprenant.component';

describe('SearchApprenantComponent', () => {
  let component: SearchApprenantComponent;
  let fixture: ComponentFixture<SearchApprenantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SearchApprenantComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(SearchApprenantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
