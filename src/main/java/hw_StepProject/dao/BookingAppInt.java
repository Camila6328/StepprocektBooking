package hw_StepProject.dao;

public interface BookingAppInt {
   public void getAllBooking();
   public String getBookingId(String bookId);
   public String getFlightId(String bookId);
   public void cancelBooking(String bookId);
   public void createdBook(int passCount);
   public void bookUpdateAvbCntFlight(String bookId, String iden);
   public void passGenerator(int passCount);
}
