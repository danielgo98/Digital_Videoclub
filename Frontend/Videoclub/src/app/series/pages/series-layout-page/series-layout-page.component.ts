import { Component, OnInit } from '@angular/core';
import { User } from '../../../auth/interfaces/user.interface';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-series-layout-page',
  templateUrl: './series-layout-page.component.html',
  styleUrl: './series-layout-page.component.css'
})
export class SeriesLayoutPageComponent implements OnInit {

  user?: User;

  constructor(private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {

    this.activatedRoute.queryParams.subscribe(params => {

      if(params && params['user']) {
        this.user = JSON.parse(params['user']);
      }

    });
  }

}
