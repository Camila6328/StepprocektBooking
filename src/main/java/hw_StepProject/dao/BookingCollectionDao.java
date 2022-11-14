package hw_StepProject.dao;

import hw_StepProject.Services.BookingService;
import hw_StepProject.Services.FlightService;
import hw_StepProject.additional.Helper;
import hw_StepProject.info.Bookings;
import hw_StepProject.info.Passangers;

import java.util.*;

public class BookingCollectionDao implements BookingAppInt {
    Dao dao = new Dao();
    Helper hp = new Helper();
    FlightCollectionDao fcd = new FlightCollectionDao();
    FlightService fs = new FlightService();
    Scanner sc = new Scanner(System.in);
    public Passangers ps = new Passangers();
    BookingService bs = new BookingService();
    public List<String> passList = new ArrayList<>();
    @Override
    public void getAllBooking() {
        hp.readFileFormatter(dao.fileB);
    }
    @Override
    public String getBookingId(String bookid) {
        return hp.findIndexFile(dao.fileB,bookid);
    }
    @Override
    public String getFlightId(String bookId) {// System.out.println("test");
        if (!getBookingId(bookId).isEmpty()){
        return getBookingId(bookId).substring(getBookingId(bookId).indexOf("Flight Details: ")+16,
                getBookingId(bookId).indexOf("Flight Details: ")+21);
        } else {
            return "id not founded";
        }
    }

    List newList = new ArrayList<>();
    public void bookUpdateAvbCntFlight(String bookId, String iden) { // CreatedBook, CancelBook
        int avbCnt = 0;
        String newVal = "";
        String val = "";
        String flightId = getFlightId(bookId);
        String flightInfo = hp.findIndexFile(dao.fileF, flightId);
        List oldList = hp.arrReadFile(dao.fileF).stream().toList();
       // System.out.println(flightInfo);
        if (!flightInfo.isEmpty()) {
            for (int i = 0; i < oldList.size(); i++) {
                String value = (String) oldList.get(i);
                String rFile = value.substring(value.indexOf("Flights{") + 8);
                if (!flightInfo.equals(rFile)) {
                    newList.add(oldList.get(i));
                } else {
                    if (iden.toLowerCase().equals("createdbook")) {
                        avbCnt = fcd.findFlightAvbCnt(flightId) - 1;
                        newVal = value.substring(0, value.indexOf("AvblSeat:  | ") + 13).concat(String.valueOf(avbCnt));
                        newList.add(newVal);
                    } else if (iden.toLowerCase().equals("cancelbook")) {
                        avbCnt = fcd.findFlightAvbCnt(flightId) + 1;
                        newVal = value.substring(0, value.indexOf("AvblSeat:  | ") + 13).concat(String.valueOf(avbCnt));
                        newList.add(newVal);
                    }
                }
            }
                fs.flightLoad("", dao.fileF, false);
            for (int i = 0; i < newList.size(); i++) {
                val = (String) newList.get(i);
                fs.flightLoad(val.substring(val.indexOf("Flights{")) + "\n", dao.fileF, true);
            }
        }
        else {
            System.out.println("This bookId not founded");
        }
    }
    @Override
    public void cancelBooking(String bookId) {
        BookingService bs = new BookingService();
        String cancelBook = hp.findIndexFile(dao.fileB, bookId);
        List oldFile = hp.arrReadFile(dao.fileB).stream().toList();
        List newList = new ArrayList<>();
        for (int i = 0; i < oldFile.size(); i++) {
            String value = (String) oldFile.get(i);
            String rFile = value.substring(value.indexOf("Bookings{ Booking ID: ") + 22);
            if (!cancelBook.equals(rFile)) {
                newList.add(oldFile.get(i));}
        }
        bookUpdateAvbCntFlight(bookId,"cancelbook");
        bs.bookingLoad("", dao.fileB, false);
        for (int i = 0; i < newList.size(); i++) {
            String val = (String) newList.get(i);
         bs.bookingLoad(val.substring(val.indexOf("Bookings{ ")) + "\n", dao.fileB, true);
        }
    }
    @Override
    public void createdBook(int passCount) {
        List<String> bookList = new ArrayList<>();
        Map<String, String> bookMap = new HashMap<>();
        System.out.print("Enter flight id: ");
        try {
            String flightId = sc.nextLine();
            String flightText = fcd.findFlight(flightId);
            if (fcd.findFlightAvbCnt(flightId) >= passCount) {
                passGenerator(passCount);
                Bookings bk = new Bookings("", ps.toString(), flightText);
                if (!flightId.isEmpty()) {
                    bk.setFlight("Flight Details: " + flightText.substring(0, flightText.indexOf(" | AvblSeat:")));
                    bookList.add(bk.toString());
                    System.out.println("********");
                    for (int j = 0; j < passList.size(); j++) {
                        String bookId = bs.randomBookIdGenerator();
                        bk.setBookingId(bookId);
                        bk.setPassenger(passList.get(j));
                        bookMap.put(bookId, bk.toString());
                        bs.bookingLoad(bk.toString(), Dao.fileB, true);
                        //bk.toString();
                        bookUpdateAvbCntFlight(bookId, "createdbook");
                    }
                    System.out.println("Success Booked");

                } else {
                    System.out.println("This Flight not found");
                }
            } else {
                System.out.println("There isn't this much free space on the plane");
            }
    }catch (Exception e){
        System.out.println("pls enter correct data");
    }
    }
    @Override
    public void passGenerator(int passCount){
        int i = 1;
        while (i <= passCount) {
            System.out.printf("Enter Name of passanger %d:", i);
            String name = hp.checkText(sc.nextLine().toUpperCase(),"Passanger Name");
            System.out.printf("Enter Surname of passanger %d:", i);
            String surname = hp.checkText(sc.nextLine().toUpperCase(),"Passanger Surname");
            ps.setName(name);
            ps.setSurname(surname);
            passList.add(ps.toString());
            i++;
        }
    }
}
