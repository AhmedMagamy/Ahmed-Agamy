package utilities;

import utilities.ReportsUtility.ExtentReport;

public class Logger {

    public static void logMessage(String message) {
        System.out.println("<" + Helper.getCurrentTime("dd-MM-yyyy HH:mm:ss.SSS a") + "> " + message);
       ExtentReport.info(message);
    }

    public static byte[] attachTextJson(byte[] b) {
        try {
            return b;
        } catch (Exception e) {
            return null;
        }
    }

    public static String attachTextJson(String b) {
        try {
            return b;
        } catch (Exception e) {
            return null;
        }
    }
}
