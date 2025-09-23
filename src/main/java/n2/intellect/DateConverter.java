package n2.intellect;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Utility class for parsing and formatting dates and date-times in multiple formats.
 * <p>
 * Supports various common formats, including numeric, textual months, as well as AM/PM time. <br>
 * Used for standardizing user inputs for tasks involving date or date-times such as deadline
 * and event tasks.
 * </p>
 */
public class DateConverter {
    /**
     * List of supported date-only patterns
     */
    public static final List<DateTimeFormatter> DATE_PATTERNS = Arrays.asList(
            DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.US),
            DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.US),
            DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US),

            DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.US),
            DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.US),

            DateTimeFormatter.ofPattern("d-M-yyyy", Locale.US),
            DateTimeFormatter.ofPattern("d/M/yyyy", Locale.US)
    );

    /**
     * List of supported date-time patterns
     */
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

    /**
     * Standardized output pattern for date-only
     */
    private static final DateTimeFormatter DATE_OUTPUT_PATTERN =
            DateTimeFormatter.ofPattern("d MMM yyyy", Locale.US);

    /**
     * Standardized output pattern for date-time
     */
    private static final DateTimeFormatter DATE_TIME_OUTPUT_PATTERN =
            DateTimeFormatter.ofPattern("d MMM yyyy, h:mma", Locale.US);

    /**
     * Parses a raw string into a LocalDate or LocalDateTime object.
     * <p>
     * Tries and exhausts all date-time patterns first, then falls back to date-only patterns. <br>
     * Returns the original string if no patterns match (e.g. today, tomorrow).
     * </p>
     * @param rawDateString input string to parse
     * @return LocalDateTime, LocalDate, or original String if parsing fails
     */
    public static Object parseDateTime(String rawDateString) {
        if (rawDateString.isEmpty()) {
            return rawDateString;
        }
        rawDateString = rawDateString
                .replaceAll("(?i)am", "AM")
                .replaceAll("(?i)pm", "PM");

        for (DateTimeFormatter pattern : DATE_TIME_PATTERNS) {
            try {
                return LocalDateTime.parse(rawDateString, pattern);
            } catch (DateTimeParseException e) {
                // Ignore and try the next DATE_TIME_PATTERN
            }
        }

        for (DateTimeFormatter pattern : DATE_PATTERNS) {
            try {
                return LocalDate.parse(rawDateString, pattern);
            } catch (DateTimeParseException e) {
                // Ignore and try the next DATE_PATTERN
            }
        }
        return rawDateString;
    }

    /**
     * Formats an object into a corresponding standardized output pattern
     *
     * @param date object to format (LocalDate, LocalDateTime, or String)
     * @return formatted date/date-time string if object is date/date-time;
     * otherwise the original string
     */
    public static String formatDateTime(Object date) {
        if (date instanceof LocalDateTime) {
            return ((LocalDateTime) date).format(DATE_TIME_OUTPUT_PATTERN);
        } else if (date instanceof LocalDate) {
            return ((LocalDate) date).format(DATE_OUTPUT_PATTERN);
        } else {
            return (String) date;
        }
    }

    /**
     * Parses an input string into a date or date-time and formats it
     * into a standardized output string
     *
     * @param input raw date or date-time string to parse
     * @return formatted date or date-time string or original input if parsing fails
     */
    public static String handleDateTimeParsing(String input) {
        Object parsedInput = parseDateTime(input);
        return formatDateTime(parsedInput);
    }
}
