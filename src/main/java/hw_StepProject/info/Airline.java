package hw_StepProject.info;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Airline {
    AZAL("AZAL"),
    TURKHAVAYOLLARI("THY"),
    WIZAIR("WIZZ");
    private final String name;
    Airline(String name) {
        this.name = name;
    }
    public String getName(){return name;}
    private static final List<Airline> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    public static Airline randomAirLines()  {return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
