import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormGroup, FormBuilder} from '@angular/forms';

@Component({
  selector: 'serie-search',
  templateUrl: './serie-search.component.html',
  styleUrl: './serie-search.component.css'
})
export class SerieSearchComponent implements OnInit{

  searchForm: FormGroup = new FormGroup({});

  @Output()
  searchSeries: EventEmitter<string> = new EventEmitter<string>();

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.searchForm = this.formBuilder.group({
      search: [''],
    });
  }

  onSubmit(): void {
    this.searchSeries.emit(this.searchForm.get('search')?.value);
  }

}
