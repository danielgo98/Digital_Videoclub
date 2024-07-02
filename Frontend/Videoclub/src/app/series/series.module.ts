import { NgModule } from '@angular/core';

import { SeriePageComponent } from './pages/serie-page/serie-page.component';
import { SeriesListPageComponent } from './pages/series-list-page/series-list-page.component';
import { CommonModule } from '@angular/common';
import { SeriesRoutingModule } from './series-routing.module';
import { SeriesLayoutPageComponent } from './pages/series-layout-page/series-layout-page.component';

@NgModule({
  imports: [
    CommonModule,
    SeriesRoutingModule,
  ],
  exports: [],
  declarations: [
    SeriesLayoutPageComponent,
    SeriePageComponent,
    SeriesListPageComponent,
  ],
})
export class SeriesModule { }