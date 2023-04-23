package bootcamps.turkcell.rentacar.common.utilities;

import java.time.LocalDate;

public class Calculation {
    public static int daysBetween(LocalDate startDate, LocalDate endDate) {
        return endDate.getDayOfYear() - startDate.getDayOfYear();
    }
}
