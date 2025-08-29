import { Component, OnInit } from '@angular/core';
import { DoctorService, Doctor } from '../../services/doctor.service';

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css']
})
export class DoctorListComponent implements OnInit {
  doctors: Doctor[] = [];

  constructor(private doctorService: DoctorService) {}

  ngOnInit(): void {
    this.doctorService.getDoctors().subscribe({
      next: data => this.doctors = data,
      error: err => console.error('Failed to load doctors', err)
    });
  }
}
