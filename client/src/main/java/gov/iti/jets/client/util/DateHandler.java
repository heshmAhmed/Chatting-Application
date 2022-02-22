package gov.iti.jets.client.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

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
}
