package gov.iti.jets.client.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Map;

public class DateHandler {
    private static final DateHandler dateHandler = new DateHandler();
    private DateHandler() {}

    public static DateHandler getInstance() {
        return dateHandler;
    }

    public long localDateToMillis(LocalDate localDate) {
        return localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public LocalDate millisToLocalDate(long millis) {
        return Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public String getCurrentTime() {
        DateTimeFormatter fmt = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("EEEE, h:mm a")
                .toFormatter(Locale.US);
        return LocalDateTime.now().format(fmt);
    }
}
