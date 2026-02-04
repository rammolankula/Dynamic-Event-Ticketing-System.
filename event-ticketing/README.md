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
<img width="602" height="816" alt="Screenshot 2026-02-04 153107" src="https://github.com/user-attachments/assets/c85c8b1e-2273-4638-a2a9-8ba98899aa63" />

<img width="814" height="289" alt="Screenshot 2026-02-04 153119" src="https://github.com/user-attachments/assets/e038caf4-fc4d-46a4-9c70-055dbb882248" />



