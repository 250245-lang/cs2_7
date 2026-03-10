import java.util.List;
import java.util.ArrayList;

public class Flight {
    private String flightNumber;
    private Airport departure;
    private Airport arrival;
    private int durationInMinutes;

    private List<WeeklySchedule> weeklySchedules;
    private List<CustomSchedule> customSchedules;
    private List<FlightInstance> flightInstances;

    public Flight(String flightNumber, Airport departure, Airport arrival, int durationInMinutes) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.durationInMinutes = durationInMinutes;
        this.weeklySchedules = new ArrayList<>();
        this.customSchedules = new ArrayList<>();
        this.flightInstances = new ArrayList<>();
    }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }
    public Airport getDeparture() { return departure; }
    public void setDeparture(Airport departure) { this.departure = departure; }
    public Airport getArrival() { return arrival; }
    public void setArrival(Airport arrival) { this.arrival = arrival; }
    public int getDurationInMinutes() { return durationInMinutes; }
    public void setDurationInMinutes(int durationInMinutes) { this.durationInMinutes = durationInMinutes; }

    public List<WeeklySchedule> getWeeklySchedules() { return weeklySchedules; }
    public void addWeeklySchedule(WeeklySchedule schedule) { this.weeklySchedules.add(schedule); }
    public List<CustomSchedule> getCustomSchedules() { return customSchedules; }
    public void addCustomSchedule(CustomSchedule schedule) { this.customSchedules.add(schedule); }
    
    public void addFlightInstance(FlightInstance instance) {
        this.flightInstances.add(instance);
    }

    public List<FlightInstance> getInstances() {
        return flightInstances;
    }

    public boolean cancel() {
        System.out.println("Flight " + flightNumber + " has been cancelled.");
        for (FlightInstance instance : flightInstances) {
            instance.cancel();
        }
        return true;
    }

    public boolean addFlightSchedule() {
        System.out.println("New schedule added to flight " + flightNumber);
        return true;
    }
}
