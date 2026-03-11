import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Time;

public class CustomSchedule {
    private LocalDate customLocalDate;
    private Time departureTime;

    public CustomSchedule(LocalDate customLocalDate, Time departureTime) {
        this.customLocalDate = customLocalDate;
        this.departureTime = departureTime;
    }

    public LocalDate getCustomLocalDate() { return customLocalDate; }
    public void setCustomLocalDate(LocalDate customLocalDate) { this.customLocalDate = customLocalDate; }
    public Time getDepartureTime() { return departureTime; }
    public void setDepartureTime(Time departureTime) { this.departureTime = departureTime; }
}
