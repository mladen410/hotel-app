import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReservationService } from '../reservation/reservation.service';
import { Reservation } from '../models/reservation';
import { Router,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrls: ['./reservation-form.component.css']
})
export class ReservationFormComponent {

  reservationForm: FormGroup;

  constructor(private formBuilder: FormBuilder, 
    private reservationService: ReservationService,
    private router: Router,
    private activateRoute: ActivatedRoute) {

    this.reservationForm = this.formBuilder.group({
      guestName: ['', Validators.required],
      guestEmail: ['', [Validators.required, Validators.email]],
      checkInDate: ['', Validators.required],
      checkOutDate: ['', Validators.required],
      roomNumber: ['', [Validators.required, Validators.min(1)]]
    });

    const reservationId = this.activateRoute.snapshot.paramMap.get('id');
    if (reservationId) {
      const reservation = this.reservationService.getReservation(+reservationId);
      if (reservation) {
        this.reservationForm.patchValue(reservation);
      }
    }
  }

  onSubmit() {
    if (this.reservationForm.valid) {
      let reservation: Reservation = this.reservationForm.value;

    const reservationId = this.activateRoute.snapshot.paramMap.get('id');
    if (reservationId) {
      this.reservationService.updateReservation(+reservationId, reservation);
    }else {
      this.reservationService.addReservation(reservation);
    }
      this.router.navigate(['/list']);
    }
  }
}
