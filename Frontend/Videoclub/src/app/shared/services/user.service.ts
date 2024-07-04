import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { User } from '../../auth/interfaces/user.interface';

@Injectable({providedIn: 'root'})
export class UserService {

  private user = new BehaviorSubject<User | null>(null);
  currentUser = this.user.asObservable();

  setUser(user: User): void {
    this.user.next(user);
  }

  getUser(): User | null {
    return this.user.value;
  }

}
