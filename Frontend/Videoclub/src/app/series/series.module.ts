import { NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { SeriePageComponent } from './pages/serie-page/serie-page.component';
import { SeriesListPageComponent } from './pages/series-list-page/series-list-page.component';
import { SeriesRoutingModule } from './series-routing.module';
import { SeriesLayoutPageComponent } from './pages/series-layout-page/series-layout-page.component';
import { SerieCardComponent } from './components/serie-card/serie-card.component';
import { SafeUrlPipe } from './pipes/safe-url.pipe';
import { SerieSearchComponent } from '../shared/components/serie-search/serie-search.component';

@NgModule({
  imports: [
    CommonModule,
    SeriesRoutingModule,
    ReactiveFormsModule
  ],
  exports: [],
  declarations: [
    SeriesLayoutPageComponent,
    SeriePageComponent,
    SeriesListPageComponent,
    SerieCardComponent,
    SafeUrlPipe,
    SerieSearchComponent,
  ],
  providers: [DatePipe]
})
export class SeriesModule { }
