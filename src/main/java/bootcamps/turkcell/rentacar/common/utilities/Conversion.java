package bootcamps.turkcell.rentacar.common.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Conversion {
    public static LocalDate date(String input, String pattern) {
        DateTimeFormatter dateTimePattern = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(input, dateTimePattern);
    }
}
