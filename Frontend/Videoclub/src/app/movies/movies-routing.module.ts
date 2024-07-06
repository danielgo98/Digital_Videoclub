import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MoviesLayoutPageComponent } from './pages/movies-layout-page/movies-layout-page.component';
import { MoviesListPageComponent } from './pages/movies-list-page/movies-list-page.component';
import { MoviePageComponent } from './pages/movie-page/movie-page.component';

const routes: Routes = [
  {
    path: '',
    component: MoviesLayoutPageComponent,
    children: [
      { path: 'list', component: MoviesListPageComponent },
      { path: ':id', component: MoviePageComponent },
      { path: '**', redirectTo: 'list' },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MoviesRoutingModule { }
