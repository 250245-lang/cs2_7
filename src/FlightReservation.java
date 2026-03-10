import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;

public class FlightReservation {
    private String reservationNumber;
    private FlightInstance flight;
    private Map<Passenger, FlightSeat> seatMap;
    private Date creationDate;
    private ReservationStatus status;

    public FlightReservation(String reservationNumber, FlightInstance flight, Date creationDate, ReservationStatus status) {
        this.reservationNumber = reservationNumber;
        this.flight = flight;
        this.creationDate = creationDate;
        this.status = status;
        this.seatMap = new HashMap<>();
    }

    public String getReservationNumber() { return reservationNumber; }
    public void setReservationNumber(String reservationNumber) { this.reservationNumber = reservationNumber; }
    public FlightInstance getFlight() { return flight; }
    public void setFlight(FlightInstance flight) { this.flight = flight; }
    public Date getCreationDate() { return creationDate; }
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }
    public ReservationStatus getStatus() { return status; }
    public void setStatus(ReservationStatus status) { this.status = status; }

    public void assignSeat(Passenger passenger, FlightSeat seat) {
        seat.setReservationNumber(this.reservationNumber);
        this.seatMap.put(passenger, seat);
    }

    public Map<Passenger, FlightSeat> getSeatMap() { return seatMap; }

    public static FlightReservation fetchReservationDetails(String reservationNumber) {
        System.out.println("Fetching details for reservation: " + reservationNumber);
        return null;
    }

    public List<Passenger> getPassengers() {
        if (seatMap == null) return new ArrayList<>();
        return new ArrayList<>(seatMap.keySet());
    }
}
