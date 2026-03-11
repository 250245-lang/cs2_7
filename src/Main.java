import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Airline uzAirline;
    private static Airport tia;
    private static Airport tea;
    private static Flight ba212;
    private static FlightInstance ba212_today;
    private static Customer currentCustomer;

    public static void main(String[] args) {
        setupData();
        clear();

        System.out.println("\n Welcome to the Airline Management System\n");

        boolean running = true;
        boolean isFirst = true;
        while(running) {
            if(isFirst){
                isFirst=false;
            }else{
                clear();
            }
            System.out.println("\nSelect Role:");
            System.out.println("1. Customer");
            System.out.println("2. Admin");
            System.out.println("3. Front Desk Officer");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    customerMenu();
                    break;
                case "2":
                    adminMenu();
                    break;
                case "3":
                    frontDeskMenu();
                    break;
                case "0":
                    System.out.println("Exiting system.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void customerMenu() {
        if (currentCustomer == null) {
            Address a1 = new Address("Unknown", "Unknown", "Unknown", "00000", "Unknown");
            Account acc = new Account("CUST-" + (int)(Math.random()*1000), "password", AccountStatus.ACTIVE);
            currentCustomer = new Customer("Guest Customer", a1, "guest@email.com", "555-0000", acc, "FF0000");
        }
        
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. Search Flights");
            System.out.println("2. Book a Flight");
            System.out.println("3. View My Itineraries");
            System.out.println("0. Go Back");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    searchFlights();
                    break;
                case "2":
                    bookFlight();
                    break;
                case "3":
                    viewItineraries();
                    break;
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void adminMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View All Flights");
            System.out.println("2. Add New Flight");
            System.out.println("3. Cancel a Flight Instance");
            System.out.println("0. Go Back");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    viewAllFlights();
                    break;
                case "2":
                    addNewFlight();
                    break;
                case "3":
                    cancelFlight();
                    break;
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void frontDeskMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Front Desk Officer Menu ---");
            System.out.println("1. Search Flights (for customer)");
            System.out.println("2. Book a Flight (for customer)");
            System.out.println("0. Go Back");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    searchFlights();
                    break;
                case "2":
                    bookFlight();
                    break;
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void setupData() {
        Address a1 = new Address("123 Main St", "Tashkent", "UZ", "10001", "Uzbekistan");
        tia = new Airport("Tashkent International Airport", a1, "TIA");
        Address a2 = new Address("123 Main St", "Tashkent", "UZ", "10001", "Uzbekistan");
        tea = new Airport("Tashkent East Airport", a2, "TEA");

        uzAirline = new Airline("Uzbek Airways", "UZB");

        Aircraft boeing = new Aircraft("Boeing 777", "777-300ER", 2018);
        boeing.addSeat(new Seat("1A", SeatType.REGULAR, SeatClass.FIRST_CLASS));
        boeing.addSeat(new Seat("1B", SeatType.REGULAR, SeatClass.FIRST_CLASS));
        boeing.addSeat(new Seat("12C", SeatType.EMERGENCY_EXIT, SeatClass.ECONOMY));

        ba212 = new Flight("BA212", tia, tea, 420);
        uzAirline.addFlight(ba212);

        ba212_today = new FlightInstance(LocalDateTime.now(), "Gate 4", FlightStatus.SCHEDULED, boeing, ba212);
        ba212.addFlightInstance(ba212_today);
        boeing.addFlightInstance(ba212_today);
    }
    
    private static void viewAllFlights() {
        System.out.println("\n--- All Flights ---");
        for (Flight f : uzAirline.getFlights()) {
            System.out.println("Flight " + f.getFlightNumber() + ": " + f.getDeparture().getCode() + " -> " + f.getArrival().getCode());
            if(f.getInstances().isEmpty()) {
                System.out.println("  No scheduled instances.");
            } else {
                for (FlightInstance fi : f.getInstances()) {
                    System.out.println("  Instance Status: " + fi.getStatus() + " | Departure: " + fi.getDepartureTime());
                }
            }
        }
        System.out.print("\n");
    }
    
    private static void addNewFlight() {
        System.out.print("Enter new flight number (e.g. BA555): ");
        String fnum = scanner.nextLine();
        Flight newf = new Flight(fnum, tea, tia, 450);
        uzAirline.addFlight(newf);
        System.out.println("Flight " + fnum + " from "+ tea.getCode()+" to "+ tia.getCode()+" added to the system.");
    }
    
    private static void cancelFlight() {
        System.out.print("Enter flight number to cancel (e.g. BA212): ");
        String cnum = scanner.nextLine();
        for (Flight f : uzAirline.getFlights()) {
             if(f.getFlightNumber().equalsIgnoreCase(cnum) && !f.getInstances().isEmpty()) {
                 f.getInstances().getFirst().cancel();
                 System.out.println("First instance of " + cnum + " cancelled.");
                 return;
             }
        }
        System.out.println("Flight or instance not found.");
    }

    private static void searchFlights() {
        viewAllFlights();
        System.out.print("Enter Departure Airport Code (e.g. TEA): ");
        String dep = scanner.nextLine();
        System.out.print("Enter Arrival Airport Code (e.g. TIA): ");
        String arr = scanner.nextLine();

        System.out.println("\nSearching flights...");
        
        boolean found = false;
        for (Flight f : uzAirline.getFlights()) {
            if (f.getDeparture().getCode().equalsIgnoreCase(dep) && f.getArrival().getCode().equalsIgnoreCase(arr)) {
                System.out.println("Found Flight: " + f.getFlightNumber() + " (" + f.getDurationInMinutes() + " mins)");
                System.out.println("Available Instances:");
                for (FlightInstance fi : f.getInstances()) {
                    System.out.println(" - " + fi.getDepartureTime() + " | Gate: " + fi.getGate() + " | Status: " + fi.getStatus());
                }
                found = true;
            }
        }

        if (!found) {
            System.out.println("No flights found for this route.");
        }
    }

    private static void bookFlight() {
        System.out.print("Enter Flight Number to book (e.g. BA212): ");
        String flightNum = scanner.nextLine();

        Flight selectedFlight = null;
        for (Flight f : uzAirline.getFlights()) {
            if (f.getFlightNumber().equalsIgnoreCase(flightNum)) {
                selectedFlight = f;
                break;
            }
        }

        if (selectedFlight == null) {
            System.out.println("Flight not found.");
            return;
        }
        
        if (selectedFlight.getInstances().isEmpty() || selectedFlight.getInstances().getFirst().getStatus().equals(FlightStatus.CANCELLED)) {
            System.out.println("No scheduled instances for this flight, or it is cancelled.");
            return;
        }

        FlightInstance instanceToBook = selectedFlight.getInstances().getFirst();

        System.out.println("Initiating booking for " + flightNum + " on " + instanceToBook.getDepartureTime());
        
        System.out.print("Passenger Name: ");
        String passName = scanner.nextLine();
        System.out.print("Passenger Passport Number: ");
        String passId = scanner.nextLine();
        
        Passenger p1 = new Passenger(passName, passId, LocalDate.of(1990, 2, 1));

        System.out.print("Enter Seat Number preference (e.g. 1A, 12C): ");
        String seatNum = scanner.nextLine();
        
        FlightSeat assignedSeat = new FlightSeat(seatNum, SeatType.REGULAR, SeatClass.ECONOMY, 500.0);

        Itinerary itinerary = new Itinerary(currentCustomer.getAccount().getId(), selectedFlight.getDeparture(), selectedFlight.getArrival(), LocalDateTime.now());
        currentCustomer.addItinerary(itinerary);

        FlightReservation res1 = new FlightReservation("RES-" + (int)(Math.random() * 10000), instanceToBook, LocalDateTime.now(), ReservationStatus.PENDING);
        res1.assignSeat(p1, assignedSeat);
        itinerary.addReservation(res1);

        System.out.println("\nReservation Pending. Total Amount: $" + assignedSeat.getFare());
        
        System.out.print("Select Payment Method (1 for Credit Card, 2 for Cash): ");
        String payMethod = scanner.nextLine();

        Payment pmt;
        boolean paid = false;
        
        if (payMethod.equals("1")) {
            System.out.print("Enter Name on Card: ");
            String ccName = scanner.nextLine();
            pmt = new CreditCardTransaction((int)(Math.random() * 1000), assignedSeat.getFare(), ccName);
            paid = pmt.makeTransaction();
        } else {
            System.out.print("Enter Cash amount: ");
            try {
                double cash = Double.parseDouble(scanner.nextLine());
                pmt = new CashTransaction((int)(Math.random() * 1000), assignedSeat.getFare(), cash);
                paid = pmt.makeTransaction();
            } catch (Exception e) {
                System.out.println("Invalid cash amount.");
            }
        }

        if (paid) {
            itinerary.makeReservation(); // Marks status to confirmed
            System.out.println("\nBooking Confirmed! Reservation Number: " + res1.getReservationNumber());
            
            Notification email = new EmailNotification((int)(Math.random() * 100), "Your flight " + flightNum + " is confirmed.", currentCustomer.getEmail());
            email.send();
        } else {
            System.out.println("\nBooking Failed due to payment issue.");
            res1.setStatus(ReservationStatus.CANCELLED);
        }
    }

    private static void viewItineraries() {
        List<Itinerary> itins = currentCustomer.getItineraries();
        if (itins.isEmpty()) {
            System.out.println("You have no itineraries.");
            return;
        }

        System.out.println("\n--- Your Itineraries ---");
        for (Itinerary i : itins) {
            System.out.println("Itinerary created on: " + i.getCreationLocalDateTime());
            System.out.println("Route: " + i.getStartingAirport().getCode() + " -> " + i.getFinalAirport().getCode());
            for (FlightReservation res : i.getReservations()) {
                System.out.println("  Reservation: " + res.getReservationNumber() + " | Status: " + res.getStatus());
                System.out.println("  Flight: " + res.getFlight().getFlight().getFlightNumber());
                for (Passenger p : res.getPassengers()) {
                    System.out.println("   - Passenger: " + p.getName() + " | Seat: " + res.getSeatMap().get(p).getSeatNumber());
                }
            }
            System.out.print("\n");
        }
    }

    public static void clear() {
        for (int i = 0; i < 5; i++) {
            System.out.println();
        }
    }
}
