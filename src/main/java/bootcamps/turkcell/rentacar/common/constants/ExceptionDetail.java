package bootcamps.turkcell.rentacar.common.constants;

public class ExceptionDetail {
    public static class Types {
        public final static String BUSINESS_EXCEPTION = "BUSINESS_EXCEPTION";
        public final static String VALIDATION_EXCEPTION = "VALIDATION_EXCEPTION";
        public final static String ILLEGAL_ARGUMENT_EXCEPTION = "ILLEGAL_ARGUMENT_EXCEPTION";
    }

    public static class Messages {
        public static class Base {
            public static final String ID_NOT_EXISTS = "'id' not exists.";
        }
        public static class Brand {
            public static final String NOT_EXISTS = "Brand not exists.";
            public static final String NAME_ALREADY_EXISTS = "Brand name already exists.";
        }

        public static class Model {
            public static final String NOT_EXISTS = "Model not exists.";
            public static final String NAME_ALREADY_EXISTS = "Model name already exists.";
        }

        public static class Car {
            public static final String NOT_EXISTS = "Car not exists.";
            public static final String NOT_AVAILABLE = "Car not available.";
            public static final String LICENCE_PLATE_ALREADY_EXISTS = "Car licence plate already exists.";
        }

        public static class Maintenance {
            public static final String NOT_EXISTS = "Maintenance not exists.";
            public static final String CAR_UNDER_MAINTENANCE = "Car under maintenance.";
            public static final String CAR_NOT_UNDER_MAINTENANCE = "Car not under maintenance.";
            public static final String CAR_CANNOT_PUT_UNDER_MAINTENANCE = "Car cannot put under maintenance.";
        }

        public static class Rental {
            public static final String NOT_EXISTS = "Rental not exists.";

            public static final String CAR_RENTED = "Car rented.";
        }
    }
}
