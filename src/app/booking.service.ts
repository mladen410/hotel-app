import { Injectable } from '@angular/core';
import { Booking } from './booking';
import { Bookings } from './mock-bookings';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor() { }

  getBookings(): Booking[]{
    return Bookings;
  }

  deleteBooking(booking: Booking): void{

    var index = Bookings.indexOf(booking);
    this.getBookings().splice(index,1);
  }

  getBookingById(id: number):Booking{
    var bookingById = Bookings.find(b => b.id == id)!;
    return bookingById;
  }

  addBooking(booking: Booking): void{
    Bookings.push(booking);
  }

  updateBooking(booking: Booking): void {
    let currentBooking = this.getBookingById(booking.id);
    currentBooking = booking;
  }
}
