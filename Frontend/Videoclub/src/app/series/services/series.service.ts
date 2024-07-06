import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Serie } from '../interfaces/series.interface';

@Injectable({providedIn: 'root'})
export class SeriesService {

  private baseUrl: string = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  public getAllSeries(): Observable<Serie[]> {
    return this.http.get<Serie[]>(`${this.baseUrl}/serie/`);
  }

  public getSerieById(id: number): Observable<Serie | undefined> {
    return this.http.get<Serie | undefined>(`${this.baseUrl}/serie/${id}`);
  }

}
