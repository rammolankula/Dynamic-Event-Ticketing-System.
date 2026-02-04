# Dynamic Event Ticketing System.

Full-stack app with Angular frontend + Spring Boot backend for seat selection and booking.

## Project Structure
├── Frontend/ # Angular UI
└── Backend/ # Spring Boot API
## Run in 4 Simple Steps

**1. Frontend**
```bash
cd Frontend
npm install && ng serve
Check http://localhost:4200 loads

2. Backend

cd Backend
mvn spring-boot:run
Backend on http://localhost:7654

3. Initialize Seats
curl -X POST http://localhost:7654/api/initialize
curl http://localhost:7654/api/initialize  # Verify

4. Test Booking

Open http://localhost:4200

Click seats → Live price updates

Buy → "Success! Total Price: $250" popup

Purchased seats → Watermark blur + disappear

Features
Real-time seat selection & pricing
Success popup with total ($250)
Booked seats: blurred watermark effect

Responsive UI

Tech
Frontend: Angular/TS
Backend: Spring Boot/Java/Maven
Ports: UI=4200, API=7654

Demo Flow
text
ng serve → mvn spring-boot:run → POST /initialize → 
Select seats → Live price → Buy → Success popup + blur effect
That's it! Your booking system is live
Reference images:
<img width="602" height="816" alt="01" src="https://github.com/user-attachments/assets/42391de0-3361-4d75-8261-3a355cc88a9e" />




