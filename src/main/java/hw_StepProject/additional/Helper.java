package hw_StepProject.additional;

import hw_StepProject.info.Users;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Helper {
    public static ArrayList<Users> userList = new ArrayList<>();

    //  public  ArrayList<String> fileDataList = new ArrayList<>();
    public void header() {
        System.out.println("**********************************************");
        System.out.println("         FLIGHT BOOKING SYSTEM");
        System.out.println("**********************************************");
    }

    public void helpInfo() {
        header();
        System.out.println(
                "           1.Login" + "\n" +
                        "           2.Register" + "\n" +
                        "           3.View AllFlights" + "\n" +
                        "           4.View Flights" + "\n" +
                        "           5.View Flights(toCity,fromDate,avbSeat)" + "\n" +
                        "           6.DELETE Flights(flightId)" + "\n" +
                        "           7.help" + "\n" +
                        "           8.exit");
    }

    public void textInfo() {
        System.out.print("Please enter your move: ");
    }

    public void helpInfoFlight() {
        header();
        System.out.println(
                "           1.View AllFlights" + "\n" +
                        "           2.View Flight" + "\n" +
                        "           3.Search && Book Flights" + "\n" +
                        "           4.View All Bookings" + "\n" +
                        "           5.View Book for BookId" + "\n" +
                        "           6.Cancel Booking" + "\n" +
                        "           7.Help" + "\n" +
                        "           8.Logout" + "\n");

    }

    public String checkText(String str, String iden) {
        boolean ischeck = true;
        Scanner sc = new Scanner(System.in);
        char firstChar = str.charAt(0);
        while (ischeck) {
            if ((firstChar >= 'a' && firstChar <= 'z') || (firstChar >= 'A' && firstChar <= 'Z')) {
                ischeck = false;
            } else {
                System.out.printf("Please Enter again, %s: ", iden);
                String strNew = sc.nextLine();
                str = checkText(strNew, iden);
                break;
            }
        }
        return str;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean checkExisting(Object obj, File file) {
        int size = arrReadFile(file).size();
        boolean check = false;
        //System.out.println(size);
        for (int i = 0; i < size; i++) {
            String value = arrReadFile(file).get(i);

            if (size == 0) {
                check = false;
                //  System.out.println(obj.toString() + "   " + value.substring(value.indexOf("Users{")));
            } else if (
                    obj.toString().equals(value.substring(value.indexOf("Users{")) + "\n")) {
                check = true;
                break;
            } else {
                check = false;
            }
        }
        return check;
    }

    public ArrayList<String> arrReadFile(File file) {
        ArrayList<String> fileDataList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);
            while (dis.available() != 0) {
                fileDataList.add(dis.readLine());
            }
            return fileDataList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileDataList;
    }

    public void readFile(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);
            while (dis.available() != 0) {
                System.out.println(dis.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFileFormatter(File file) {
        int size = arrReadFile(file).size();
        String rFile = "";
        for (int i = 0; i < size; i++) {
            String value = arrReadFile(file).get(i);
            if (size == 0) {
                rFile = "";
                System.out.println(rFile);
            } else if (file.getName() == "users.txt") {
                rFile = value.substring(value.indexOf("Users{") + 6);
                if (!rFile.trim().isEmpty()) {
                    System.out.println(rFile);
                }
            } else if (file.getName().equals("flights.txt")) {
                rFile = value.substring(value.indexOf("Flights{") + 8);
                if (!rFile.trim().isEmpty()) {
                    System.out.println(rFile);
                }
            } else if (file.getName().equals("booking.txt")) {
                rFile = value.substring(value.indexOf("Bookings{ ") + 10);
                if (!rFile.trim().isEmpty()) {
                    System.out.println(rFile);
                }
            }
        }
    }

    public String findIndexFile(File file, String objId) {
        int size = arrReadFile(file).size();
        String rFile = "";
        try {
            if (size == 0) {
                rFile = "";
                return rFile;
            } else {
                for (int i = 0; i < size; i++) {
                    String value = arrReadFile(file).get(i);
                    if (file.getName().equals("flights.txt")) {
                        String indFlight = value.substring(value.indexOf("Flights{") + 8, value.indexOf("Flights{") + 13);
                        if (indFlight.equals(objId)) {
                            return value.substring(value.indexOf("Flights{") + 8);
                        }
                    } else if (file.getName().equals("booking.txt")) {
                        String indBook = value.substring(value.indexOf("Bookings{ Booking ID: ") + 22,
                                value.indexOf("Bookings{ Booking ID: ") + 26);
                        if (indBook.equals(objId)) {
                            return value.substring(value.indexOf("Bookings{ Booking ID: ") + 22);
                        }
                    } else if (file.getName().equals("users.txt")) {
                        String rFile1 = value.substring(value.indexOf("Users{"));
                        rFile = value.substring(value.indexOf("Users{") + 6);
                        if (!rFile1.equals("Users{}")) {
                            if (!rFile.isEmpty()) {
                                String userText = value.substring(rFile.indexOf("username= ") + 17);
                                String indUser = userText.substring(userText.indexOf("username= ") + 10, userText.indexOf(", password"));
                                if (indUser.equals(objId)) {
                                    return userText.substring(0, userText.length() - 1);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            return "id not fonded";
        }
        return "";
    }
}