/*
 *  Helper functions for generating the Calendar and the algorithm behind it
	@file CalendarGenerator.java
    @author Debasree Sen
    @version Eclipse Version: 2024-03 (4.31.0)
 * 
 * 
 * 
 */

package Calendar;

public class CalendarGenerator {

    public static String generateCalendar(int year, int month) {
        StringBuilder calendar = new StringBuilder();
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        // Add day names
        for (String day : days) {
            calendar.append(day).append("\t");
        }
        calendar.append("\n");

        // Generate the calendar for the given year and month
        int firstDayOfWeek = weekStart(year, month);
        int daysInMonth = numDays(year, month);

        // Add empty spaces for days before the first day of the month
        for (int i = 0; i < firstDayOfWeek; i++) {
            calendar.append("\t");
        }

        // Add day numbers
        for (int day = 1; day <= daysInMonth; day++) {
            calendar.append(day).append("\t");
            if ((day + firstDayOfWeek) % 7 == 0) {
                calendar.append("\n");
            }
        }

        return calendar.toString();
    }

    /*
     * Returns the day the 1st of the month begins on (0-6 for Sun-Sat)
     * and stores the number of days preceding this input from Jan 1st, 1800
     */
    public static int weekStart(int year, int month) {
        int totalDays = 0; // total days preceding input year and month from Jan 1st, 1800

        // adding up all days of years and leap years until specified year
        for (int i = 1800; i < year; i++) {
            totalDays += 365 + isLeapYear(i);
        }

        // adding up days until specified month
        for (int j = 1; j < month; j++) {
            totalDays += numDays(year, j);
        }

        int start = (totalDays + 3) % 7; // 1800 Jan 1st starts on a Wednesday so + 3
        return start;
    }

    /*
     * Returns 1 if input year is a leap year or 0 if it isn't
     */
    public static int isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return 1; // 1600, a leap year
                }
            } else {
                return 1; // 1988, a leap year
            }
        }
        return 0; // 1900, not a leap year
    }

    /*
     * Returns the number of days within the input month
     */
    public static int numDays(int year, int month) {
        int days = 0;

        // Jan, March, May, July, August, October, December = 31 days
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            days = 31;
        }
        // April, June, September, November = 30 days
        else if (month == 4 || month == 6 || month == 9 || month == 11) {
            days = 30;
        }
        // February = 28 or 29 days depending on if year is a leap year
        else {
            days = 28 + isLeapYear(year);
        }

        return days;
    }
}
