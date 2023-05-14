package dev.charith.JobListApp.utility;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


//Util class for date and time formatting
public class DateTimeUtil {

    // Format a date time string in ISO format to a local time format
    public static String formatToLocalTime(String dateTimeStr) {

        if (dateTimeStr == null || dateTimeStr.trim().isEmpty()) {
            return "";
        } else {
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ISO_DATE_TIME);
            LocalTime localTime = dateTime.toLocalTime();
            String formattedTime = localTime.format(DateTimeFormatter.ofPattern("h:mm a")).toLowerCase(Locale.ROOT);
            return formattedTime;
        }

    }


    // Format a date time string to a date string in "dd MMMM yyyy" format
    public static String formatDate(String dateTimeStr) {

        if (dateTimeStr == null || dateTimeStr == null || dateTimeStr.trim().isEmpty()) {
            return "";
        } else {
            Instant instant = Instant.parse(dateTimeStr);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));
            String date = localDateTime.format(DateTimeFormatter.ISO_DATE);
            LocalDate localdate = LocalDate.parse(date);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
            String formattedDate = localdate.format(formatter);
            return formattedDate;
        }

    }

    // Convert a timestamp string to a formatted date and time string
    public static String convertTimestamp(String timestamp) {
        if (timestamp == null || timestamp == null || timestamp.trim().isEmpty()) {
            return "";
        } else {
            String date = DateTimeUtil.formatDate(timestamp);
            String time = DateTimeUtil.formatToLocalTime(timestamp);
            return (date + " " + time);
        }


    }

    // Format a duration in milliseconds to a string
    public static String formatMiliSeconds(long duration) {

        double seconds = (double) duration / 1000.0;
        return String.format("%.2f ms", seconds);

    }
}
