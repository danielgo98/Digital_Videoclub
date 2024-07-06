import { Component, Input } from '@angular/core';
import { Movie } from '../../interfaces/movies.interface';

@Component({
  selector: 'movie-card',
  templateUrl: './movie-card.component.html',
  styleUrl: './movie-card.component.css'
})
export class MovieCardComponent {

  @Input()
  movie!: Movie;

}
