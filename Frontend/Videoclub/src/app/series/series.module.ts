import { NgModule } from '@angular/core';

import { SeriePageComponent } from './pages/serie-page/serie-page.component';
import { SeriesListPageComponent } from './pages/series-list-page/series-list-page.component';
import { CommonModule, DatePipe } from '@angular/common';
import { SeriesRoutingModule } from './series-routing.module';
import { SeriesLayoutPageComponent } from './pages/series-layout-page/series-layout-page.component';
import { SerieCardComponent } from './components/serie-card/serie-card.component';
import { SafeUrlPipe } from './pipes/safe-url.pipe';

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
    SerieCardComponent,
    SafeUrlPipe,
  ],
  providers: [DatePipe]
})
export class SeriesModule { }
