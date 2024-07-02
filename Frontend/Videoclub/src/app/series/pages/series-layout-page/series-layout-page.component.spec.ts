import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeriesLayoutPageComponent } from './series-layout-page.component';

describe('SeriesLayoutPageComponent', () => {
  let component: SeriesLayoutPageComponent;
  let fixture: ComponentFixture<SeriesLayoutPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SeriesLayoutPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SeriesLayoutPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
