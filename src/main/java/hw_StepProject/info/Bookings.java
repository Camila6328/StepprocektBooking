package hw_StepProject.info;

public class Bookings {
    String bookingId;
    String passenger;
    String flight;
   // private static int counter = 0;

    public Bookings() {
    }

    public Bookings(String bookingId, String passenger, String flight) {
        this.bookingId = bookingId;
        //counter++;
        this.passenger = passenger;
        this.flight = flight;
    }
    @Override
    public String toString() {
        return "Bookings{ " +
                "Booking ID: " + getBookingId() + "  " +
                getPassenger().toString() + "  " +
                flight +"\n";
    }
    public String getPassenger() {
        return passenger;
    }
    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }
    public String getFlight() {
        return flight;
    }
    public void setFlight(String flight) {
        this.flight = flight;
    }
    public String getBookingId() {return bookingId;}
    public void setBookingId(String bookingId) {this.bookingId = bookingId;}
}
