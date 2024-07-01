import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { catchError, throwError } from 'rxjs';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  loginForm: FormGroup = new FormGroup({});
  userInfo: string = '';

  constructor(private formBuilder: FormBuilder,
              private authService: AuthService) {}

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
        this.userInfo = 'Error al iniciar sesión, comprueba los datos introducidos.';
        return[];
      })
    )
    .subscribe();
  }


}
