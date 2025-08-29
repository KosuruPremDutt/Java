import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <h1>Doctor Appointment Booking System</h1>
    <nav>
      <a routerLink="/doctors" routerLinkActive="active">Doctors</a> |
      <a routerLink="/book-appointment" routerLinkActive="active">Book Appointment</a>
    </nav>
    <router-outlet></router-outlet>
  `,
  styles: [`
    nav a { margin-right: 15px; }
    .active { font-weight: bold; }
  `]
})
export class AppComponent { }
