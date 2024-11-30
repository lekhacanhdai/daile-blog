import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DlbCardComponent } from './dlb-card.component';

describe('DlbCardComponent', () => {
  let component: DlbCardComponent;
  let fixture: ComponentFixture<DlbCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DlbCardComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(DlbCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
