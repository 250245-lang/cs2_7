import java.util.Date;

public class FlightInstance {
    private Date departureTime;
    private String gate;
    private FlightStatus status;
    private Aircraft aircraft;
    private Flight flight;

    public FlightInstance(Date departureTime, String gate, FlightStatus status, Aircraft aircraft, Flight flight) {
        this.departureTime = departureTime;
        this.gate = gate;
        this.status = status;
        this.aircraft = aircraft;
        this.flight = flight;
    }

    public Date getDepartureTime() { return departureTime; }
    public void setDepartureTime(Date departureTime) { this.departureTime = departureTime; }
    public String getGate() { return gate; }
    public void setGate(String gate) { this.gate = gate; }
    public FlightStatus getStatus() { return status; }
    
    public Aircraft getAircraft() { return aircraft; }
    public void setAircraft(Aircraft aircraft) { this.aircraft = aircraft; }
    public Flight getFlight() { return flight; }
    public void setFlight(Flight flight) { this.flight = flight; }

    public boolean cancel() {
        this.status = FlightStatus.CANCELLED;
        System.out.println("Flight instance cancelled.");
        return true;
    }

    public void updateStatus(FlightStatus status) {
        this.status = status;
        System.out.println("Flight instance status updated to: " + status);
    }
}
