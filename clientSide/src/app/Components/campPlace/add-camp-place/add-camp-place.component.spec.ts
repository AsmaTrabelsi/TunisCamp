import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCampPlaceComponent } from './add-camp-place.component';

describe('AddCampPlaceComponent', () => {
  let component: AddCampPlaceComponent;
  let fixture: ComponentFixture<AddCampPlaceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCampPlaceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddCampPlaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
