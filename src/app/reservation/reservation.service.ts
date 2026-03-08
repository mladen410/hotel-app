import { Injectable } from '@angular/core';
import { Reservation } from '../models/reservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private reservations: Reservation[] = [];

  constructor() { 
    const storedReservations = localStorage.getItem('reservations');
    this.reservations = JSON.parse(storedReservations ?? '[]');
  }

  getReservations(): Reservation[] {
    return this.reservations;
  }

  getReservation(id: number): Reservation | undefined {
    return this.reservations.find(reservation => reservation.id === id);
  }

  addReservation(reservation: Reservation): void {
    console.log('Adding reservation:', reservation);
    reservation.id = Date.now();
    this.reservations.push(reservation);
    localStorage.setItem('reservations', JSON.stringify(this.reservations));
  }

  updateReservation(id: number, updatedReservation: Reservation): void {
    const index = this.reservations.findIndex(reservation => reservation.id === id);
    if (index !== -1) {
      this.reservations[index] = updatedReservation;
      localStorage.setItem('reservations', JSON.stringify(this.reservations));
    }
  }

  deleteReservation(id: number): void {
    this.reservations = this.reservations.filter(reservation => reservation.id !== id);
    localStorage.setItem('reservations', JSON.stringify(this.reservations));
  } 
}
