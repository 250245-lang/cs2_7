import java.util.Map;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;

public class FlightReservation {
    private String reservationNumber;
    private FlightInstance flight;
    private Map<Passenger, FlightSeat> seatMap;
    private Date creationDate;
    private ReservationStatus status;

    public static FlightReservation fetchReservationDetails(String reservationNumber) {
        return null;
    }

    public List<Passenger> getPassengers() {
        if (seatMap == null) return new ArrayList<>();
        return new ArrayList<>(seatMap.keySet());
    }
}
