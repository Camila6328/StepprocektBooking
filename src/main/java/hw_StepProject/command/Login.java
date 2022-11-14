package hw_StepProject.command;

import hw_StepProject.dao.BookingCollectionDao;
import hw_StepProject.additional.FlightOrBookData;
import hw_StepProject.dao.FlightCollectionDao;
import hw_StepProject.additional.Helper;
import hw_StepProject.dao.Dao;
import hw_StepProject.info.Users;
import java.util.*;
public class Login {
    Helper hp = new Helper();
    Scanner sc = new Scanner(System.in);
    FlightCollectionDao fcd = new FlightCollectionDao();
    FlightOrBookData fd = new FlightOrBookData();
    BookingCollectionDao bcd = new BookingCollectionDao();
    boolean isSecCheck = true;
    public void login() {
        System.out.print("Enter user Username: ");
        String username = hp.checkText(sc.nextLine(),"Username");
        System.out.print("Enter user password: ");
        String password = sc.nextLine();
//        System.out.print("Enter user Name: ");
//        String name = hp.checkText(sc.nextLine(),"Name");
//        System.out.print("Enter user Surname: ");
//        String surname = hp.checkText(sc.nextLine(),"Surname");
//        Users user = new Users(name, surname,username, password);
        Users user = new Users(username, password);
        if (hp.checkExisting(user, Dao.fileU) == true) {
            hp.helpInfoFlight();
            isSecCheck = true;
       }
        else { System.out.println("Please Enter Correct User info: ");
            isSecCheck = false;
               // hp.helpInfo();
        }
    }
    public String numeric(String strId) {//  sc.nextLine();
        if (hp.isNumeric(strId) == true) {
           return strId;//int sysId = Integer.parseInt(strId);
        }
        else {
            return "Please enter again number";
        }
    }
    public void loginLoop() {
        Scanner sc = new Scanner(System.in);
        Helper help = new Helper();
        while(isSecCheck) {
            hp.textInfo();
            String strId = sc.nextLine();
          if (help.isNumeric(strId) == true) {
              int sysId = Integer.parseInt(strId);
              if (sysId == 1) {
                  System.out.println("View All Flights");
                  fcd.getAllFlights();
              }
              if (sysId == 2) {
                  System.out.print("Please Enter FlightID:");
                  System.out.println(fcd.findFlight(sc.nextLine()));
              }
              if (sysId == 3) {//Search && Book Flights
                  fd.bookingInfo();
              }
              if (sysId == 4) {
                  System.out.println("View All Bookings");
                  bcd.getAllBooking();
              }
              if (sysId == 5) {
                  System.out.print("Please Enter BookID: ");
                  System.out.println(bcd.getBookingId(sc.nextLine()));
              }
              if (sysId == 6) {
                  System.out.print("Please Enter Cancel BookID :");
                  bcd.cancelBooking(sc.nextLine());
                 // System.out.println("Cancel Booking");
              }
              if (sysId == 7) {
                  hp.helpInfoFlight();
              }
              if (sysId == 8) {
                  isSecCheck = false;
                  System.out.println("Goodbye,logout");
              }
              if (sysId > 8) {
                  System.out.println("Please Enter Again");
              }
          } else {
              System.out.println("Please Enter Again");
          }
        }
    }
}
