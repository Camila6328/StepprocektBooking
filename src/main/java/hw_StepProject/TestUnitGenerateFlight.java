package hw_StepProject;

import hw_StepProject.additional.FlightGenerator;
import hw_StepProject.dao.FlightCollectionDao;
import org.junit.Test;

import java.text.ParseException;

public class TestUnitGenerateFlight extends BookingManager {
    @Test
    public void getAllFlightsTest() throws ParseException {
        FlightCollectionDao fcd = new FlightCollectionDao();
        FlightGenerator fg = new FlightGenerator();
        fcd.saveFlight(fg.generateFlights());
    }

    }
