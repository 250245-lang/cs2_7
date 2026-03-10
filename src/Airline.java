import java.util.List;
import java.util.ArrayList;

public class Airline {
    private String name;
    private String code;
    private List<Flight> flights;

    public Airline(String name, String code) {
        this.name = name;
        this.code = code;
        this.flights = new ArrayList<>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    public List<Flight> getFlights() {
        return this.flights;
    }
}
