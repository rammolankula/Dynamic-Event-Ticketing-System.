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
<img width="602" height="816" alt="Screenshot 2026-02-04 153107" src="https://github.com/user-attachments/assets/9cb219ad-0816-443e-a3d0-0b80428201ae" />
<img width="814" height="289" alt="Screenshot 2026-02-04 153119" src="https://github.com/user-attachments/assets/fee270ef-cb22-498f-95ef-4051f0fface6" />
<img width="1137" height="433" alt="Screenshot 2026-02-04 124049" src="https://github.com/user-attachments/assets/0a6bec2d-5d01-456b-bd48-0970a7a781c1" />


