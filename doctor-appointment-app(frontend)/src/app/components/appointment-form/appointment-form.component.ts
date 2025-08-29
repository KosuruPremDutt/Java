import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DatePipe } from '@angular/common';

interface Doctor {
  id: number;
  name: string;
  specialization: string;
}

@Component({
  selector: 'app-appointment-form',
  templateUrl: './appointment-form.component.html',
  styleUrls: ['./appointment-form.component.css'],
  providers: [DatePipe]
})
export class AppointmentFormComponent implements OnInit {
  doctors: Doctor[] = [];
  appointment = {
    doctorId: '',
    patientName: '',
    date: '',
    time: '',
    contact: ''
  };
  message = '';

  constructor(private http: HttpClient, private datePipe: DatePipe) {}

  ngOnInit(): void {
    this.loadDoctors();
  }

  loadDoctors(): void {
    this.http.get<Doctor[]>('http://localhost:8080/api/doctors')
      .subscribe({
        next: data => this.doctors = data,
        error: err => {
          this.message = 'Failed to load doctors list.';
          console.error('Error loading doctors:', err);
        }
      });
  }

  submitForm(): void {
    const selectedDoctor = this.doctors.find(doc => doc.id === +this.appointment.doctorId);
    if (!selectedDoctor) {
      this.message = 'Please select a valid doctor.';
      return;
    }

    const formattedDate = this.datePipe.transform(this.appointment.date, 'yyyy-MM-dd');
    if (!formattedDate) {
      this.message = 'Invalid date format.';
      return;
    }

    const payload = {
      doctorId: +this.appointment.doctorId,
      patientName: this.appointment.patientName.trim(),
      date: formattedDate,
      time: this.appointment.time,
      contact: this.appointment.contact.trim()
    };

    console.log('Submitting payload:', payload); // Debug log

    this.http.post('http://localhost:8080/api/appointments', payload)
      .subscribe({
        next: () => {
          this.message = 'Appointment booked successfully!';
          this.appointment = { doctorId: '', patientName: '', date: '', time: '', contact: '' };
        },
        error: error => {
          let errMsg = 'Failed to book appointment.';
          
          if (error.error) {
            if (typeof error.error === 'string') {
              errMsg = error.error;
            } else if (error.error.message) {
              errMsg = error.error.message;
            } else {
              try {
                errMsg = JSON.stringify(error.error);
              } catch {
                errMsg = 'Unknown server error.';
              }
            }
          }

          this.message = `Error booking appointment: ${errMsg}`;
          console.error('Error booking appointment:', error);
        }
      });
  }
}
