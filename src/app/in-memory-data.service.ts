import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Booking } from './booking';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService{

  createDb(){

      const bookings: Booking[] = [

        {
            id: 1,
            name: "John",
            roomNumber: 100,
            startDate: new Date(),
            endDate: new Date()
          },
          {
            id: 2,
            name: "Mike",
            roomNumber: 200,
            startDate: new Date(),
            endDate: new Date()
          },
          {
            id: 3,
            name: "Joe",
            roomNumber: 300,
            startDate: new Date(),
            endDate: new Date()
          }
    
    ]
    return {bookings};
  }

  constructor() { }
}
