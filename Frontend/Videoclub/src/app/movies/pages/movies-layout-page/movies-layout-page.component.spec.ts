import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoviesLayoutPageComponent } from './movies-layout-page.component';

describe('MoviesLayoutPageComponent', () => {
  let component: MoviesLayoutPageComponent;
  let fixture: ComponentFixture<MoviesLayoutPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MoviesLayoutPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MoviesLayoutPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
