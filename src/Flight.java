import java.util.List;

public class Flight {
    private String flightNumber;
    private Airport departure;
    private Airport arrival;
    private int durationInMinutes;

    private List<WeeklySchedule> weeklySchedules;
    private List<CustomSchedule> customSchedules;
    private List<FlightInstance> flightInstances;
    
    public List<FlightInstance> getInstances() {
        return flightInstances;
    }
    
    public boolean cancel() {
        return false;
    }
    
    public boolean addFlightSchedule() {
        return false;
    }
}
