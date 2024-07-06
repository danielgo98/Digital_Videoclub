import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Movie } from '../interfaces/movies.interface';

@Injectable({providedIn: 'root'})
export class MoviesService {

  private baseUrl: string = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  public getAllMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(`${this.baseUrl}/movie/`);
  }

  public getMovieById(id: number): Observable<Movie | undefined> {
    return this.http.get<Movie | undefined>(`${this.baseUrl}/movie/${id}`);
  }

  public getMovieByTitle(title: string): Observable<Movie[] | undefined> {
    return this.http.get<Movie[] | undefined>(`${this.baseUrl}/movie/title/${title}`);
  }

}
