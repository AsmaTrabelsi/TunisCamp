import { TestBed } from '@angular/core/testing';

import { CampPlaceService } from './camp-place.service';

describe('CampPlaceService', () => {
  let service: CampPlaceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CampPlaceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
