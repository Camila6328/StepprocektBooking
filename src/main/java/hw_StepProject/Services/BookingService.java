package hw_StepProject.Services;
import hw_StepProject.additional.Helper;
import hw_StepProject.info.Passangers;
import java.io.*;
import java.util.*;
public class BookingService {
    public void bookingLoad(String booking, File file, boolean append) {
        try (FileOutputStream fs = new FileOutputStream(file,append);
             BufferedOutputStream bs = new BufferedOutputStream(fs);
             ObjectOutputStream os = new ObjectOutputStream(bs);
        ) {
            os.writeObject(booking.toString());
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public  String randomBookIdGenerator() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 4;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }


}
