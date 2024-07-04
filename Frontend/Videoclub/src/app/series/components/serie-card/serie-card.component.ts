import { Component, Input, OnInit } from '@angular/core';
import { Serie } from '../../interfaces/series.interface';

@Component({
  selector: 'serie-card',
  templateUrl: './serie-card.component.html',
  styleUrl: './serie-card.component.css'
})
export class SerieCardComponent implements OnInit{

  @Input()
  serie!: Serie;

  ngOnInit(): void {
    if(!this.serie) throw new Error('Serie property is required');
  }


}
