import java.util.List;
import java.util.ArrayList;

public class Airport {
    private String name;
    private Address address;
    private String code;
    private List<Flight> flights;

    public Airport(String name, Address address, String code) {
        this.name = name;
        this.address = address;
        this.code = code;
        this.flights = new ArrayList<>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    public List<Flight> getFlights() {
        return this.flights;
    }
}
