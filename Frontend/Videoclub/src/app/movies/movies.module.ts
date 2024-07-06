import { NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { MoviePageComponent } from './pages/movie-page/movie-page.component';
import { MoviesListPageComponent } from './pages/movies-list-page/movies-list-page.component';
import { MoviesLayoutPageComponent } from './pages/movies-layout-page/movies-layout-page.component';
import { MoviesRoutingModule } from './movies-routing.module';
import { MovieCardComponent } from './components/movie-card/movie-card.component';
import { SafeUrlPipe } from './pipes/safe-url.pipe';
import { MovieSearchComponent } from '../shared/components/movie-search/movie-search.component';


@NgModule({
  imports: [
    CommonModule,
    MoviesRoutingModule,
    ReactiveFormsModule
  ],
  exports: [],
  declarations: [
    MoviePageComponent,
    MoviesListPageComponent,
    MoviesLayoutPageComponent,
    MovieCardComponent,
    SafeUrlPipe,
    MovieSearchComponent
  ],
  providers: [DatePipe],
})
export class MoviesModule { }
