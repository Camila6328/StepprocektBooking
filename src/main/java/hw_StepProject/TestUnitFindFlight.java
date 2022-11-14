package hw_StepProject;

import hw_StepProject.dao.FlightCollectionDao;
import org.junit.Test;

public class TestUnitFindFlight {// BookingManager.appC.findFlight()
    @Test
    public void findFlightTest() {
        String flightId = "Puv4J";
        FlightCollectionDao fcd = new FlightCollectionDao();
        System.out.println(fcd.findFlight(flightId));

    }
}
