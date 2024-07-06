import { NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';

import { MoviePageComponent } from './pages/movie-page/movie-page.component';
import { MoviesListPageComponent } from './pages/movies-list-page/movies-list-page.component';
import { MoviesLayoutPageComponent } from './pages/movies-layout-page/movies-layout-page.component';
import { MoviesRoutingModule } from './movies-routing.module';
import { MovieCardComponent } from './components/movie-card/movie-card.component';
import { SafeUrlPipe } from './pipes/safe-url.pipe';

@NgModule({
  imports: [
    CommonModule,
    MoviesRoutingModule,
  ],
  exports: [],
  declarations: [
    MoviePageComponent,
    MoviesListPageComponent,
    MoviesLayoutPageComponent,
    MovieCardComponent,
    SafeUrlPipe
  ],
  providers: [DatePipe],
})
export class MoviesModule { }
