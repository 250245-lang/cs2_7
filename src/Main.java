import java.util.Date;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Airline Management System Demo ===\n");

        // 1. Setup Data
        Address a1 = new Address("123 Main St", "New York", "NY", "10001", "USA");
        Account acc1 = new Account("CUST001", "pass123", AccountStatus.ACTIVE);
        Customer john = new Customer("John Doe", a1, "john@example.com", "555-1234", acc1, "FF12345");

        Airport jfk = new Airport("John F Kennedy", a1, "JFK");
        Airport lhr = new Airport("Heathrow", new Address("456 High St", "London", "LON", "W1", "UK"), "LHR");

        Airline ba = new Airline("British Airways", "BA");

        Aircraft boeing = new Aircraft("Boeing 777", "777-300ER", 2018);
        Seat s1 = new Seat("1A", SeatType.REGULAR, SeatClass.FIRST_CLASS);
        boeing.addSeat(s1);

        Flight ba212 = new Flight("BA212", jfk, lhr, 420);
        ba.addFlight(ba212);

        FlightInstance ba212_today = new FlightInstance(new Date(), "Gate 4", FlightStatus.SCHEDULED, boeing, ba212);
        ba212.addFlightInstance(ba212_today);
        boeing.addFlightInstance(ba212_today);

        System.out.println("Flight " + ba212.getFlightNumber() + " from " + jfk.getCode() + " to " + lhr.getCode() + " scheduled.");

        // 2. Customer Searches and Books
        Itinerary itinerary = new Itinerary(acc1.getId(), jfk, lhr, new Date());
        john.addItinerary(itinerary);

        FlightReservation res1 = new FlightReservation("RES-999", ba212_today, new Date(), ReservationStatus.PENDING);
        
        Passenger p1 = new Passenger("John Doe", "PASS-XYZ-1", new Date(90, 1, 1));
        FlightSeat fs1 = new FlightSeat(s1.getSeatNumber(), s1.getSeatType(), s1.getSeatClass(), 1200.0);
        
        res1.assignSeat(p1, fs1);
        itinerary.addReservation(res1);

        System.out.println("\nReservation created: " + res1.getReservationNumber());
        System.out.println("Passenger: " + p1.getName() + " assigned to seat " + fs1.getSeatNumber());
        System.out.println("Total fare: $" + fs1.getFare());

        // 3. Payment
        Payment pmt = new CreditCardTransaction(1001, 1200.0, "John Doe");
        boolean paid = pmt.makeTransaction();

        if (paid) {
            itinerary.makeReservation();
            System.out.println("Itinerary reservation status updated.");
            
            // 4. Notification
            Notification email = new EmailNotification(100, "Your flight BA212 is confirmed.", john.getEmail());
            email.send();
        }

        System.out.println("\n=== Demo Complete ===");
    }
}
