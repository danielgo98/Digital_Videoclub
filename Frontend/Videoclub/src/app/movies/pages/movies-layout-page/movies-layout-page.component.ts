import { Component, OnInit } from '@angular/core';
import { User } from '../../../auth/interfaces/user.interface';
import { UserService } from '../../../shared/services/user.service';

@Component({
  selector: 'app-movies-layout-page',
  templateUrl: './movies-layout-page.component.html',
  styleUrl: './movies-layout-page.component.css'
})
export class MoviesLayoutPageComponent implements OnInit {

  currentUser?: User | null;

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    console.log(this.userService.getUser());
    this.currentUser = this.userService.getUser();
  }

}
