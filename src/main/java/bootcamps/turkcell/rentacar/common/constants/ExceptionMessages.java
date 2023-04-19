package bootcamps.turkcell.rentacar.common.constants;

public class ExceptionMessages {
    public static class Brand {
        public static final String NOT_EXISTS = "BRAND_NOT_EXISTS";
        public static final String NAME_ALREADY_EXISTS = "BRAND_NAME_ALREADY_EXISTS";
    }

    public static class Model {
        public static final String NOT_EXISTS = "MODEL_NOT_EXISTS";
        public static final String NAME_ALREADY_EXISTS = "MODEL_NAME_ALREADY_EXISTS";
    }

    public static class Car {
        public static final String NOT_EXISTS = "CAR_NOT_EXISTS";
        public static final String NOT_AVAILABLE = "CAR_NOT_AVAILABLE";
        public static final String LICENCE_PLATE_ALREADY_EXISTS = "CAR_LICENCE_PLATE_ALREADY_EXISTS";
    }

    public static class Maintenance {
        public static final String NOT_EXISTS = "MAINTENANCE_NOT_EXISTS";
        public static final String CAR_UNDER_MAINTENANCE = "CAR_UNDER_MAINTENANCE";
        public static final String CAR_NOT_UNDER_MAINTENANCE = "CAR_NOT_UNDER_MAINTENANCE";
        public static final String CAR_RENTED = "CAR_RENTED";
    }


}
