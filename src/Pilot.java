import java.util.List;
import java.util.ArrayList;

public class Pilot extends Person {
    private List<FlightInstance> flights;

    public Pilot(String name, Address address, String email, String phone, Account account) {
        super(name, address, email, phone, account);
        this.flights = new ArrayList<>();
    }

    public void assignFlight(FlightInstance flight) {
        this.flights.add(flight);
    }

    public List<FlightInstance> getFlights() {
        return this.flights;
    }
}
