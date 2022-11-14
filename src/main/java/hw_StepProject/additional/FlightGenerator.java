package hw_StepProject.additional;

import hw_StepProject.Services.FlightService;
import hw_StepProject.command.Flights;
import java.text.ParseException;
public class FlightGenerator {
    public Flights generateFlights() throws ParseException {
        Flights fl = new Flights();
        FlightService fs = new FlightService();
        Flights fl1 = new Flights(fs.randomIdGenerator(), fl.getAirport(), fl.getAirline(),
                fs.randomDateGenerator(), fs.randomDateTimeGenerator(), fl.getDestination(),
                fs.randomAvbTicketCnt());
        return fl1;
    }

}
