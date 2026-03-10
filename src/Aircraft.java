import java.util.List;
import java.util.ArrayList;

public class Aircraft {
    private String name;
    private String model;
    private int manufacturingYear;
    private List<Seat> seats;
    private List<FlightInstance> flights;

    public Aircraft(String name, String model, int manufacturingYear) {
        this.name = name;
        this.model = model;
        this.manufacturingYear = manufacturingYear;
        this.seats = new ArrayList<>();
        this.flights = new ArrayList<>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getManufacturingYear() { return manufacturingYear; }
    public void setManufacturingYear(int manufacturingYear) { this.manufacturingYear = manufacturingYear; }

    public List<Seat> getSeats() { return seats; }
    public void addSeat(Seat seat) { this.seats.add(seat); }

    public void addFlightInstance(FlightInstance flight) {
        this.flights.add(flight);
    }

    public List<FlightInstance> getFlights() {
        return this.flights;
    }
}
