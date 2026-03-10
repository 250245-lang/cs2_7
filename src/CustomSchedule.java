import java.util.Date;
import java.sql.Time;

public class CustomSchedule {
    private Date customDate;
    private Time departureTime;

    public CustomSchedule(Date customDate, Time departureTime) {
        this.customDate = customDate;
        this.departureTime = departureTime;
    }

    public Date getCustomDate() { return customDate; }
    public void setCustomDate(Date customDate) { this.customDate = customDate; }
    public Time getDepartureTime() { return departureTime; }
    public void setDepartureTime(Time departureTime) { this.departureTime = departureTime; }
}
