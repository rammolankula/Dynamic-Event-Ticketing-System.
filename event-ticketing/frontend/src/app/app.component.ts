import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']   // 🔴 must exist
})

export class AppComponent implements OnInit {
  backendUrl = 'http://localhost:7654/api';
  seats: any[] = [];
  selected: number[] = [];
  totalPrice = 0;

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.loadSeats();
  }

  loadSeats() {
    this.http.get<any[]>(`${this.backendUrl}/seats`)
      .subscribe(data => this.seats = data);
  }

  toggleSeat(seat: any) {
    if (seat.booked) return;

    if (this.selected.includes(seat.id)) {
      this.selected = this.selected.filter(id => id !== seat.id);
    } else {
      this.selected.push(seat.id);
    }
    this.calculateTotal();
  }

  calculateTotal() {
    let total = 0;

    this.selected.forEach(seatNumber => {
      if (seatNumber >= 1 && seatNumber <= 50) {
        total += 50;
      } else if (seatNumber >= 51 && seatNumber <= 80) {
        total += 75;
      } else if (seatNumber >= 81 && seatNumber <= 100) {
        total += 100;
      }
    });

    this.totalPrice = total;
  }


  buy() {
    if (!this.selected.length) {
      alert('Select seats first');
      return;
    }

    this.http.post<any>(`${this.backendUrl}/book`, {
      seatIds: this.selected,
      userName: 'User'
    }).subscribe({
      next: res => {
        alert(`Success! Total Price: $${res.totalPrice}`);
        this.selected = [];
        this.totalPrice = 0;
        this.loadSeats();
      },
      error: err => alert(err.error || 'Booking failed')
    });
  }
}
