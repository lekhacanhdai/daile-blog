import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DlbInputComponent } from './dlb-input.component';

describe('DlbInputComponent', () => {
  let component: DlbInputComponent;
  let fixture: ComponentFixture<DlbInputComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DlbInputComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(DlbInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
