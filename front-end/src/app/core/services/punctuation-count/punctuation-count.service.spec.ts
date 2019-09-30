import { TestBed } from '@angular/core/testing';

import { PunctuationCountService } from './punctuation-count.service';

describe('PunctuationCountService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PunctuationCountService = TestBed.get(PunctuationCountService);
    expect(service).toBeTruthy();
  });
});
