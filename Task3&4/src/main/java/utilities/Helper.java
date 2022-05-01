package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static org.testng.Assert.fail;

public class Helper {


    public static String getCurrentTime(String dateFormat) {
        String currentTime = "";
        try {
            currentTime = new  SimpleDateFormat(dateFormat).format(new Date());
        } catch (IllegalArgumentException e) {
            Logger.logMessage(e.getMessage());
            fail(e.getMessage());
        }
        return currentTime;
    }
    public static String getCurrentTimeStamp() {
        return getCurrentTime("ddMMyyyyHHmmssSSS");
    }

    public static int getRandomNumberBetweenTwoValues(int lowValue, int highValue) {
        return new Random().nextInt(highValue - lowValue) + lowValue;
    }

    public static String getRandomNumberBetweenTwoValuesAsString(int lowValue, int highValue) {
        return Integer.toString(getRandomNumberBetweenTwoValues(lowValue, highValue));
    }
}
