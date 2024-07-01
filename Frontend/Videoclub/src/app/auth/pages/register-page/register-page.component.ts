import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { catchError } from 'rxjs';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrl: './register-page.component.css'
})
export class RegisterPageComponent implements OnInit {

  registerForm: FormGroup = new FormGroup({});

  userInfo: string = '';

  constructor(private formBuilder: FormBuilder, private authService: AuthService) {}


  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      email: ['', Validators.required]
    });
  }

  public onSubmit(): void {
    if(!this.registerForm.value) return;

    this.authService.register(this.registerForm.value)
    .pipe(
      catchError(error => {
        this.userInfo = 'Error al crear la cuenta, los datos introducidos no son correctos';
        console.error(error);
        return [];
      })
    )
    .subscribe();
  }

}
