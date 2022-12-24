import { Component, OnInit } from '@angular/core';
import { Booking } from '../booking';
import { BookingService } from '../booking.service';
@Component({
  selector: 'app-bookings',
  templateUrl: './bookings.component.html',
  styleUrls: ['./bookings.component.css']
})
export class BookingsComponent implements OnInit{

bookings : Booking [] = [];

constructor(private bookingService: BookingService){

}
  ngOnInit(): void {
    // subscribe -> asynchron. wartet auf die Antwort. Wenn die Antwort da ist wird this.bookings mit dem inhalt aus result befüllt.
    this.bookingService.getBookings().subscribe((result) => {this.bookings = result});
  }


deleteBooking(booking: Booking): void{

  this.bookingService.deleteBooking(booking).subscribe();
  this.bookingService.getBookings().subscribe((result) => {this.bookings = result});
}

}


