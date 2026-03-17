import { Injectable } from '@angular/core';
import { Reservation } from '../models/reservation';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'; 

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private apiUrl = 'http://localhost:8080/';

  constructor(private http: HttpClient) { 
  }

  getReservations(): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(this.apiUrl + 'reservations');
  }

  getReservation(id: number): Observable<Reservation> {
    return this.http.get<Reservation>(this.apiUrl + 'reservation/' + id);  
  }

  addReservation(reservation: Reservation): Observable<Reservation> {
    return this.http.post<Reservation>(this.apiUrl + 'reservation', reservation);
  }

  updateReservation(id: number, updatedReservation: Reservation): Observable<Reservation> {
    return this.http.put<Reservation>(this.apiUrl + 'reservation/' + id, updatedReservation);
  }

  deleteReservation(id: number): Observable<void> {
    return this.http.delete<void>(this.apiUrl + 'reservation/' + id)
  } 
}
