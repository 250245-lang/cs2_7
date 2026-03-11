import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

public class Itinerary {
    private String customerId;
    private Airport startingAirport;
    private Airport finalAirport;
    private LocalDateTime creationLocalDateTime;
    private List<FlightReservation> reservations;

    public Itinerary(String customerId, Airport startingAirport, Airport finalAirport, LocalDateTime creationLocalDateTime) {
        this.customerId = customerId;
        this.startingAirport = startingAirport;
        this.finalAirport = finalAirport;
        this.creationLocalDateTime = creationLocalDateTime;
        this.reservations = new ArrayList<>();
    }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public Airport getStartingAirport() { return startingAirport; }
    public void setStartingAirport(Airport startingAirport) { this.startingAirport = startingAirport; }
    public Airport getFinalAirport() { return finalAirport; }
    public void setFinalAirport(Airport finalAirport) { this.finalAirport = finalAirport; }
    public LocalDateTime getCreationLocalDateTime() { return creationLocalDateTime; }
    public void setCreationLocalDateTime(LocalDateTime creationLocalDateTime) { this.creationLocalDateTime = creationLocalDateTime; }

    public void addReservation(FlightReservation reservation) {
        this.reservations.add(reservation);
    }

    public List<FlightReservation> getReservations() {
        return this.reservations;
    }

    public boolean makeReservation() {
        System.out.println("Making reservation for itinerary...");
        for (FlightReservation req : reservations) {
            req.setStatus(ReservationStatus.CONFIRMED);
        }
        return true;
    }

    public boolean makePayment() {
        System.out.println("Processing payment for itinerary...");
        return true;
    }
}
