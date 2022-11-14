package hw_StepProject.info;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Airport {
    BAKU("BKU"),
    GANJA("GNJ"),
    GABALA("GBL"),
    TURKEY("TRKY"),
    FRANCE("FRNS"),
    AUSTRIA("ASTR"),
    CHEZK("CHZK"),
    ANKARA("ANKR"),
    LONDON("LND"),
    KIEV("KV"),
    NEWYORK("NWY"),
    BERLIN("BRLN"),
    TOKYO("TKY"),
    FRANKFURT("FRA");
    private final String code;
    Airport(String code) {
        this.code =code;
    }
    public String getCode(){return code ;}
    private static final List<Airport> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    public static Airport randomAirport()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

}
