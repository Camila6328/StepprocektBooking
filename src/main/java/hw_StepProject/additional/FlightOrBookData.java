package hw_StepProject.additional;
import hw_StepProject.Services.FlightService;
import hw_StepProject.dao.BookingCollectionDao;
import hw_StepProject.dao.Dao;
import hw_StepProject.dao.FlightCollectionDao;
import java.util.Scanner;

public class FlightOrBookData {
    FlightCollectionDao fcd = new FlightCollectionDao();
    BookingCollectionDao bcd = new BookingCollectionDao();
    Helper hp = new Helper();
    Dao dao = new Dao();
    FlightService fs = new FlightService();
    public void findFlightOrBookData(String iden){ // *** Booking,Flight
        System.out.println("Please Enter ToCity,date(yyyy/mm/dd) format and avbSeat count:");
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter ToCity name: ");
        String toCity = sc1.nextLine();
        System.out.print("Enter fromDate(yyyy/mm/dd) format: ");
        String fromDate = sc1.nextLine();
        if (iden =="Flight") {
            System.out.print("Enter avbSeat count: ");
            try {
                int cnt = sc1.nextInt();
                fcd.findFlight(toCity,fromDate,cnt);
            }catch (Exception e){
                System.out.println("pls enter correct data");
            }
        } else if (iden == "Booking"){
            System.out.print("Enter number of passangers you'd like to book seats for :");
            int passCount = sc1.nextInt();
            bcd.createdBook(passCount);
        }
    }
    public void bookingInfo() {
        boolean isThCheck = true;
        while (isThCheck) {
            System.out.print("Would you like to make a booking now? Y/N ? ");
            Scanner sc1 = new Scanner(System.in);
            String iden = sc1.nextLine().toUpperCase();
            if (iden.equals("Y")) {
                findFlightOrBookData("Booking");
                break;
            } else if (iden.equals("N")) {
                System.out.println("Thanks");
                hp.helpInfoFlight();
                break;
            } else {
                isThCheck = true;
            }
        }
    }

}
