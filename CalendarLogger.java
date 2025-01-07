/*
 * Helper functions for creating the logs and reading logs
@file CalendarLogger.java
@author Fardin Choudhury , Brianna Herrera
@version Eclipse Version: 2024-03 (4.31.0)
 */

package Calendar;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * creates  the .csv file with user inputs 
 */

public class CalendarLogger {
    private static final String file = "calendar_log.csv";

    public void logCalendar(int year, int month, String calendar) {
        try {
            FileWriter log = new FileWriter(file, true);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // records time and date calendar was made
            String timestamp = sdf.format(new Date());

            log.write("Timestamp: " + timestamp + "\n"); // records time and date calendar was made
            log.write("Input: Year=" + year + ", Month=" + month + "\n"); // records user input 
            log.write("Calendar:\n" + calendar + "\n"); // records calendar created
            log.write("----------------------------------------\n"); // space between records 
            log.close(); // closes file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/* 
 * reads the .csv file to be displayed on the gui 
 */
    public String logRead() {
        StringBuilder logContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                logContent.append(line).append("\n"); // takes the .csv file into logContent
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logContent.toString(); // returns 
    }

    public void appendToAnotherFile(String content, String targetFileName) {
        try (FileWriter writer = new FileWriter(targetFileName, true)) { // Append mode
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}