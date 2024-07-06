import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'auth',
    loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule)
  },
  {
    path: 'series',
    loadChildren: () => import('./series/series.module').then(m => m.SeriesModule)
  },
  {
    path: 'movies',
    loadChildren: () => import('./movies/movies.module').then(m => m.MoviesModule)
  },
  {
    path: '',
    redirectTo: 'auth',
    pathMatch: 'full'
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
