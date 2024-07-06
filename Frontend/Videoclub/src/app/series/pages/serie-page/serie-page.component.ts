import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs';

import { Serie } from '../../interfaces/series.interface';
import { SeriesService } from '../../services/series.service';

@Component({
  selector: 'app-serie-page',
  templateUrl: './serie-page.component.html',
  styleUrl: './serie-page.component.css'
})
export class SeriePageComponent implements OnInit {

  serie?: Serie;

  constructor(private serieService: SeriesService,
              private activatedRoute: ActivatedRoute,
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params
    .pipe(
      switchMap( ({id}) => this.serieService.getSerieById(id))
    )
    .subscribe(serie => {
      this.serie = serie;
      return;
    });

  }

}
