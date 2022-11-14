package hw_StepProject.dao;
import hw_StepProject.additional.Helper;
import hw_StepProject.Services.FlightService;
import hw_StepProject.command.Flights;

import java.util.*;

public class FlightCollectionDao implements FlightAppInt
{
    static Dao dao = new Dao();
    Helper hp = new Helper();
    FlightService fs = new FlightService();
    @Override
    public void getAllFlights() {
        hp.readFileFormatter(dao.fileF);
    }
    @Override
    public void saveFlight(Flights flight) {
        fs.flightLoad(flight.toString(),dao.fileF,true);
    }
    @Override
    public String findFlight(String flightId) {
        if(!hp.findIndexFile(dao.fileF,flightId).isEmpty()){
        return hp.findIndexFile(dao.fileF,flightId);}
        else {
            return "Id not founded";
        }
    }
    @Override
    public void findFlight(String toCity, String fromDate, int passCnt) {
        int size = hp.arrReadFile(dao.fileF).size();
        String rFile = "";
        for (int i = 0; i < size; i++) {
            String value = hp.arrReadFile(dao.fileF).get(i);
            if (size == 0) {
                rFile = "";
                System.out.println(rFile);
            } else {
                rFile = value.substring(value.indexOf("Flights{") + 8);
                List ls = Arrays.stream(Arrays.stream(rFile.split(" | ")).toArray()).toList();
                String indDate =  (String) ls.get(2);
                String indCity = (String) ls.get(7);
                String avblSeat = (String) ls.get(14);
                if (indDate.equals(fromDate) && indCity.equals((toCity)) && Integer.parseInt(avblSeat)>=passCnt) {
                    System.out.println(rFile);
                }else {
                    System.out.println("This flight not available");
                    break;
                }
            }
        }
    }
    @Override
    public void deleteFlight(String flightId) {
        String deletedFlight = hp.findIndexFile(dao.fileF, flightId);
        System.out.println(deletedFlight);
        List oldFile = hp.arrReadFile(dao.fileF).stream().toList();
        List newList = new ArrayList<>();
            for (int i = 0; i < oldFile.size(); i++) {
                String value = (String) oldFile.get(i);
                String rFile = value.substring(value.indexOf("Flights{") + 8);
                if (!deletedFlight.equals(rFile)) {
                    newList.add(oldFile.get(i));}
                }
        fs.flightLoad("", dao.fileF, false);
            for (int i = 0; i < newList.size(); i++) {
                String val = (String) newList.get(i);
                fs.flightLoad(val.substring(val.indexOf("Flights{")) + "\n", dao.fileF, true);
            }
    }
    @Override
    public int findFlightAvbCnt(String flightId) {
        String rFile = hp.findIndexFile(dao.fileF,flightId);
        if (!flightId.isEmpty()) {
            List ls = Arrays.stream(Arrays.stream(rFile.split(" | ")).toArray()).toList();
            String avblSeat = (String) ls.get(14);
            return Integer.parseInt(avblSeat);
        }
        else {
            return 0;
        }
    }
    @Override
    public String chooseFlight(String flightId) {
        if (findFlightAvbCnt(flightId)>0) {
            return findFlight(flightId);
        }else {
            return "Please Enter available flight ID: ";
        }
    }

}
