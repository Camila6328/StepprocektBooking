package hw_StepProject;
import hw_StepProject.additional.FlightGenerator;
import hw_StepProject.additional.FlightOrBookData;
import hw_StepProject.additional.Helper;
import hw_StepProject.command.Login;
import hw_StepProject.command.RegisterUser;
import hw_StepProject.dao.FlightCollectionDao;

import java.text.ParseException;
import java.util.Scanner;
public class BookingManager {
    static FlightGenerator fg = new FlightGenerator();
    static FlightCollectionDao fcd = new FlightCollectionDao();

    public void run() {
        FlightOrBookData fb = new FlightOrBookData();
        Scanner sc = new Scanner(System.in);
        boolean isMainCheck = true;
        Helper help = new Helper();
        Login lg = new Login();
        FlightCollectionDao fcd = new FlightCollectionDao();
        while (isMainCheck) {
            help.helpInfo();
            help.textInfo();
            String strId = sc.nextLine();
            if (help.isNumeric(strId) == true) {
                int sysId = Integer.parseInt(strId);
                if (sysId == 1) {
                    lg.login();
                    lg.loginLoop();
                }
                if (sysId == 2) {
                    RegisterUser ru = new RegisterUser();
                    ru.register();
                }
                if (sysId == 3) {
                    System.out.println("View AllFlights");
                    fcd.getAllFlights();
                }
                if (sysId == 4) {
                    System.out.print("Please Enter FlightID: ");
                    System.out.println(fcd.findFlight(sc.nextLine()));
                }
                if (sysId == 5) {
                    fb.findFlightOrBookData("Flight");
                }
                if (sysId == 6) {
                    System.out.print("Please Enter FlightID: ");
                    fcd.deleteFlight(sc.nextLine());
                }
                if (sysId == 7) {
                    help.helpInfo();
                }
                if (sysId == 8) {
                    isMainCheck = false;
                    System.out.println("Goodbye");
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



