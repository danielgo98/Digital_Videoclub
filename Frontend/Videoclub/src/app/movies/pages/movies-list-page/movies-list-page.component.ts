import { Component, OnInit } from '@angular/core';
import { Movie } from '../../interfaces/movies.interface';
import { MoviesService } from '../../services/movies.service';

@Component({
  selector: 'app-movies-list-page',
  templateUrl: './movies-list-page.component.html',
  styleUrl: './movies-list-page.component.css'
})
export class MoviesListPageComponent implements OnInit {

  private movies: Movie[] = [];

  moviesFound: Movie[] = [];

  constructor(private movieService: MoviesService) {}

  ngOnInit(): void {
    this.movieService.getAllMovies()
    .subscribe( response => {
      const moviesFetched: Movie[] = [];
      response.forEach(movie => moviesFetched.push(movie));
      this.movies =  moviesFetched;
    });
  }

  public showAllMovies(): Movie[] {
    this.moviesFound = [];
    return this.movies;
  }

  findMovie(title: string): void {

    if(title == '') this.showAllMovies();

    this.movieService.getMovieByTitle(title)
    .subscribe(response => {
      if (response) {
        this.moviesFound = response;
      } else {
        this.moviesFound = [];
      }
    });

  }

}
