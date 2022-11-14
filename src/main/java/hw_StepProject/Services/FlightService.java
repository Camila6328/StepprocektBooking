package hw_StepProject.Services;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class FlightService {
    Calendar c = Calendar.getInstance(Locale.ENGLISH);
    public String randomIdGenerator() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
    public String randomDateGenerator() {
        Date d = c.getTime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
        return sdf1.format(d) + (int) (Math.random() * 10);
    }
    public String randomDateTimeGenerator() {
        Date d = c.getTime();
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm");
        return sdf2.format(d) + (int) (Math.random() * 100);
    }
    public int randomAvbTicketCnt(){
        Random r = new Random();
        int low = 1;
        int high = 100;
        return r.nextInt(high-low) + low;
    }
    public void flightLoad(String flight, File file, boolean append) {
        try (FileOutputStream fs = new FileOutputStream(file,append);
             BufferedOutputStream bs = new BufferedOutputStream(fs);
             ObjectOutputStream os = new ObjectOutputStream(bs);
        ) {
            os.writeObject(flight.toString());
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

