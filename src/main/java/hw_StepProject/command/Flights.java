package hw_StepProject.command;

import hw_StepProject.info.Airline;
import hw_StepProject.info.Airport;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Flights implements Serializable {
    String flightId; //serial number of flight
    Airport airport;
    Airline airline;
    String flightDate;
    String flightTime;
    String destination;
    int avblTicketCnt;
    public Flights() {};
    public Flights(String flightId, Airport airport, Airline airline, String flightDate,String flightTime, String destination, int avblTicketCnt) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm");
        Date date1 = sdf1.parse(flightDate);
        Date date2 = sdf2.parse(flightTime);
        this.flightId = flightId;
        this.airport = airport;
        this.airline = airline;
        this.flightDate = sdf1.format(date1);
        this.flightTime = sdf2.format(date2);
        this.destination = destination;
        this.avblTicketCnt = avblTicketCnt;
    }
    @Override
    public String toString() {
        return  "Flights{" +
                flightId + " | " +
                flightDate + " " + flightTime +" | " +
                "KIEV"  +  " ---> " + destination + " | " +
                airline +  " | " +
                "AvblSeat: " + " | " + avblTicketCnt + '\n';
        }

    public String toStringAlt() {
        return  "Flight Details" +
                flightId + " | " +
                flightDate + " " + flightTime +" | " +
                "KIEV"  +  " ---> " + destination + " | " +
                airline +  " | " ;
    }
    public String getFlightId() {
        return flightId;
    }
    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }
    public Airport getAirport() {
        return Airport.randomAirport();
    }
    public void setAirport(Airport airport) {
        this.airport = airport;
    }
    public Airline getAirline() {
        return Airline.randomAirLines();
    }
    public void setAirline(Airline airline) {
        this.airline = airline;
    }
    public int getAvblTicketCnt() {
        return avblTicketCnt;
    }
    public void setAvblTicketCnt(int avblTicketCnt) {
        this.avblTicketCnt = avblTicketCnt;
    }
    public String getFlightDate() {
        return flightDate;
    }
    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }
    public String getFlightTime() {
        return flightTime;
    }
    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }
    public String getDestination() {
        return getAirport().toString();
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

}
