import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { SeriesListPageComponent } from './pages/series-list-page/series-list-page.component';
import { SeriePageComponent } from './pages/serie-page/serie-page.component';
import { SeriesLayoutPageComponent } from './pages/series-layout-page/series-layout-page.component';

const routes: Routes = [
  {
    path: '',
    component: SeriesLayoutPageComponent,
    children: [
      { path: 'list', component: SeriesListPageComponent },
      { path: ':id', component: SeriePageComponent },
      { path: '**', redirectTo: 'list' },
    ]
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SeriesRoutingModule { }
