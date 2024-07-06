import { Component, OnInit } from '@angular/core';
import { Serie } from '../../interfaces/series.interface';
import { SeriesService } from '../../services/series.service';


@Component({
  selector: 'app-series-list-page',
  templateUrl: './series-list-page.component.html',
  styleUrls: ['./series-list-page.component.css']
})
export class SeriesListPageComponent implements OnInit {

  seriesFound: Serie[] = [];

  private series: Serie[] = [];

  constructor(private serieService: SeriesService) {}

  ngOnInit(): void {
    this.serieService.getAllSeries()
    .subscribe(response => {
      const seriesFetched: Serie[] = [];
      response.forEach(serieResponse => seriesFetched.push(serieResponse));
      this.series = seriesFetched;
      this.showAllSeries();
    });
  }

  public showAllSeries(): Serie[] {
    this.seriesFound = [];
    return this.series;
  }

  findSerie(name: string): void {

    if(name == '') this.showAllSeries();

    this.serieService.getSerieByName(name)
      .subscribe(response => {
        if (response) {
          this.seriesFound = response;
        } else {
          this.seriesFound = [];
        }
      });
  }

}
