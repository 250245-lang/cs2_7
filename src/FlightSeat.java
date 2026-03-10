public class FlightSeat extends Seat {
    private double fare;
    private String reservationNumber;

    public FlightSeat(String seatNumber, SeatType type, SeatClass _class, double fare) {
        super(seatNumber, type, _class);
        this.fare = fare;
    }

    public double getFare() {
        return this.fare;
    }
    public void setFare(double fare) { this.fare = fare; }

    public String getReservationNumber() { return reservationNumber; }
    public void setReservationNumber(String reservationNumber) { this.reservationNumber = reservationNumber; }
}
