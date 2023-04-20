package bootcamps.turkcell.rentacar.business.rules;

import bootcamps.turkcell.core.utilities.exceptions.business.BusinessException;
import bootcamps.turkcell.rentacar.common.constants.ExceptionMessages;
import bootcamps.turkcell.rentacar.domain.enums.CarState;
import bootcamps.turkcell.rentacar.repository.CarRepository;
import bootcamps.turkcell.rentacar.repository.RentalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentalBusinessRules {
    private final RentalRepository rentalRepository;
    private final CarRepository carRepository;

    public void carCannotBeRentedWhenRented(int carId) {
        if (rentalRepository.existsByCarId(carId)) {
            throw new BusinessException(ExceptionMessages.Rental.CAR_RENTED);
        }
    }

    public void carCannotBeFinishedWhenNotRented(int carId) {
        if (!rentalRepository.existsByCarIdAndEndDateNull(carId)) {
            throw new BusinessException(ExceptionMessages.Maintenance.CAR_NOT_UNDER_MAINTENANCE);
        }
    }

    public void carCannotBeRentedWhenMaintenance(int carId) {
        if (!carRepository.findById(carId).orElseThrow().getState().equals(CarState.MAINTENANCE)) {
            throw new BusinessException(ExceptionMessages.Maintenance.CAR_UNDER_MAINTENANCE);
        }
    }

    public void carCannotBeRentedWhenNotAvailable(int carId) {
        if (!carRepository.findById(carId).orElseThrow().getState().equals(CarState.AVAILABLE)) {
            throw new BusinessException(ExceptionMessages.Car.NOT_AVAILABLE);
        }
    }
}
