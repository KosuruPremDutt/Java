import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DoctorListComponent } from './components/doctor-list/doctor-list.component';
import { AppointmentFormComponent } from './components/appointment-form/appointment-form.component';
import { HomeComponent } from './components/home/home.component'; 
const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'doctors', component: DoctorListComponent },
  { path: 'appointments', component: AppointmentFormComponent },
  { path: '**', redirectTo: '' } // redirect unknown paths to home
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
