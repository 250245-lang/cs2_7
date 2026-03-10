import java.util.List;
import java.util.Date;

public class Itinerary {
    private String customerId;
    private Airport startingAirport;
    private Airport finalAirport;
    private Date creationDate;
    private List<FlightReservation> reservations;

    public List<FlightReservation> getReservations() {
        return this.reservations;
    }

    public boolean makeReservation() {
        return false;
    }

    public boolean makePayment() {
        return false;
    }
}
