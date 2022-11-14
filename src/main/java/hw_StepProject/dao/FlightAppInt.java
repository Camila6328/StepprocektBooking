package hw_StepProject.dao;

import hw_StepProject.command.Flights;

public interface FlightAppInt {
    public void saveFlight(Flights flight);
    public void getAllFlights();
    public String findFlight(String flightId);
    public void findFlight(String toCity,String fromDate,int passCnt);
    public void deleteFlight(String  flightId);
    public int findFlightAvbCnt(String flightId);
    public String chooseFlight(String flightId);
}
