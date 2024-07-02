import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { catchError } from 'rxjs';

import { AuthService } from '../../services/auth.service';
import { User } from '../../interfaces/user.interface';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  loginForm: FormGroup = new FormGroup({});
  userInfo: string = '';
  userLogged?: User;

  constructor(private formBuilder: FormBuilder,
              private authService: AuthService,
            private router: Router) {}

  ngOnInit(): void {
      this.loginForm = this.formBuilder.group({
        username: ['', Validators.required],
        password: ['', Validators.required]
      });
  }

  public onSubmit(): void {
    this.authService.login(this.loginForm.value)
    .pipe(
      catchError(error => {
        debugger;
        this.userInfo = 'Error al iniciar sesión, comprueba los datos introducidos.';
        return[];
      })
    )
    .subscribe(response => {
      const userResponse: User =  {
        id: response.id,
        username: response.username,
        password: response.password,
        email: response.email
      };
      this.userLogged = userResponse;
      this.logginSuccess();
      this.userInfo = '';
    });
  }

  private logginSuccess(): void {
    console.log(this.userLogged);
  }


}
