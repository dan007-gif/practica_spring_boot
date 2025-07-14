import { TestBed } from '@angular/core/testing';

import { Festivos } from './festivos';

describe('Festivos', () => {
  let service: Festivos;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Festivos);
  });

  it('iiiii', () => {
    expect(service).toBeTruthy();
  });
});
