import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PunctuationCountComponent } from './punctuation-count.component';

describe('PunctuationCountComponent', () => {
  let component: PunctuationCountComponent;
  let fixture: ComponentFixture<PunctuationCountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PunctuationCountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PunctuationCountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
