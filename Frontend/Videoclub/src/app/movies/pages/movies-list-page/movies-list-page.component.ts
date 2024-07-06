import { Component, OnInit } from '@angular/core';
import { Movie } from '../../interfaces/movies.interface';
import { MoviesService } from '../../services/movies.service';

@Component({
  selector: 'app-movies-list-page',
  templateUrl: './movies-list-page.component.html',
  styleUrl: './movies-list-page.component.css'
})
export class MoviesListPageComponent implements OnInit {

  movies?: Movie[];

  constructor(private movieService: MoviesService) {}

  ngOnInit(): void {
    debugger;
    this.movieService.getAllMovies()
    .subscribe( movies => this.movies = movies);
  }
}
