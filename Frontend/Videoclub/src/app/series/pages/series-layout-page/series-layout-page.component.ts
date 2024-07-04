import { Component, OnInit } from '@angular/core';
import { User } from '../../../auth/interfaces/user.interface';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../../../shared/services/user.service';

@Component({
  selector: 'app-series-layout-page',
  templateUrl: './series-layout-page.component.html',
  styleUrl: './series-layout-page.component.css'
})
export class SeriesLayoutPageComponent implements OnInit {

  currentUser?: User | null;

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    console.log(this.userService.getUser());
    this.currentUser = this.userService.getUser();
  }

}
