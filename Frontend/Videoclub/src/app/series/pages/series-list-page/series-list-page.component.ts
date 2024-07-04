import { Component, OnInit } from '@angular/core';
import { Serie } from '../../interfaces/series.interface';
import { SeriesService } from '../../services/series.service';

@Component({
  selector: 'app-series-list-page',
  templateUrl: './series-list-page.component.html',
  styleUrls: ['./series-list-page.component.css']
})
export class SeriesListPageComponent implements OnInit {

  private series: Serie[] = [];

  loading: boolean = true;

  constructor(private serieService: SeriesService) {}

  ngOnInit(): void {
    this.serieService.getAllSeries()
    .subscribe(response => {
      debugger;
      const seriesFetched: Serie[] = [];
      response.forEach(serieResponse => seriesFetched.push(serieResponse));
      this.series = seriesFetched;
      this.showAllSeries();
    });
  }

  public showAllSeries(): Serie[] {
    return this.series;
  }

}
