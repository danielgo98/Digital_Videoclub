import { Component, OnInit } from '@angular/core';
import { Movie } from '../../interfaces/movies.interface';
import { MoviesService } from '../../services/movies.service';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs';

@Component({
  selector: 'app-movie-page',
  templateUrl: './movie-page.component.html',
  styleUrl: './movie-page.component.css'
})
export class MoviePageComponent implements OnInit {

  movie!: Movie;
  movieTrailer: string = '';

  constructor(private movieService: MoviesService,
              private activatedRoute: ActivatedRoute
            ) {}

  ngOnInit(): void {
    this.activatedRoute.params
    .pipe(
      switchMap( ({id}) => this.movieService.getMovieById(id))
    )
    .subscribe(movie => {

      if(movie) {
        this.movie = movie
      }

    });
    return;
  }

}
