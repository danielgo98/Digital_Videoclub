import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'movie-search',
  templateUrl: './movie-search.component.html',
  styleUrl: './movie-search.component.css'
})
export class MovieSearchComponent implements OnInit{

  searchForm: FormGroup = new FormGroup({});

  @Output()
  searchMovies: EventEmitter<string> = new EventEmitter<string>();

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.searchForm = this.formBuilder.group({
      search: [''],
    });
  }

  onSubmit(): void {
    this.searchMovies.emit(this.searchForm.get('search')?.value);
  }

}
