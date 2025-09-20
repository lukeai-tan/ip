package n2.intellect;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DateConverter {
    public static final List<DateTimeFormatter> DATE_PATTERNS = Arrays.asList(
            DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.US),
            DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.US),
            DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US),

            DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.US),
            DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.US),

            DateTimeFormatter.ofPattern("d-M-yyyy", Locale.US),
            DateTimeFormatter.ofPattern("d/M/yyyy", Locale.US)
    );

    public static final List<DateTimeFormatter> DATE_TIME_PATTERNS = Arrays.asList(
            // common style
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm", Locale.US),
            DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mma", Locale.US),
            DateTimeFormatter.ofPattern("dd/MM/yyyy H:mm", Locale.US),
            DateTimeFormatter.ofPattern("dd/MM/yyyy h:mm", Locale.US),
            DateTimeFormatter.ofPattern("dd/MM/yyyy h:mma", Locale.US),

            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm", Locale.US),
            DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mma", Locale.US),

            // dot time style
            DateTimeFormatter.ofPattern("yyyy/MM/dd h.mma", Locale.US),
            DateTimeFormatter.ofPattern("dd/MM/yyyy h.mma", Locale.US),
            DateTimeFormatter.ofPattern("yyyy-MM-dd h.mma", Locale.US),
            DateTimeFormatter.ofPattern("dd-MM-yyyy h.mma", Locale.US),

            // month as month names
            DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm", Locale.US),
            DateTimeFormatter.ofPattern("dd MMM yyyy hh:mma", Locale.US),
            DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm", Locale.US),
            DateTimeFormatter.ofPattern("dd MMMM yyyy hh:mma", Locale.US),

            // database style
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.US)
    );

    private static final DateTimeFormatter DATE_OUTPUT_PATTERN =
            DateTimeFormatter.ofPattern("d MMM yyyy", Locale.US);

    private static final DateTimeFormatter DATE_TIME_OUTPUT_PATTERN =
            DateTimeFormatter.ofPattern("d MMM yyyy, h:mma", Locale.US);

    public static Object parseDateTime(String rawDateString) {
        rawDateString = rawDateString
                .replaceAll("(?i)am", "AM")
                .replaceAll("(?i)pm", "PM");

        for (DateTimeFormatter pattern : DATE_TIME_PATTERNS) {
            try {
                return LocalDateTime.parse(rawDateString, pattern);
            } catch (DateTimeParseException e) {

            }
        }

        for (DateTimeFormatter pattern : DATE_PATTERNS) {
            try {
                return LocalDate.parse(rawDateString, pattern);
            } catch (DateTimeParseException e) {

            }
        }
        return rawDateString;
    }

    public static String formatDateTime(Object date) {
        if (date instanceof LocalDateTime) {
            return ((LocalDateTime) date).format(DATE_TIME_OUTPUT_PATTERN);
        } else if (date instanceof LocalDate) {
            return ((LocalDate) date).format(DATE_OUTPUT_PATTERN);
        } else {
            return (String) date;
        }
    }

    public static String handleDateTimeParsing(String input) {
        Object parsedInput = parseDateTime(input);
        return formatDateTime(parsedInput);
    }
}
