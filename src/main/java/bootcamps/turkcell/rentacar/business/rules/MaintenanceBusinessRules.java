package bootcamps.turkcell.rentacar.business.rules;

import bootcamps.turkcell.core.utilities.exceptions.business.BusinessException;
import bootcamps.turkcell.rentacar.common.constants.ExceptionMessages;
import bootcamps.turkcell.rentacar.domain.enums.CarState;
import bootcamps.turkcell.rentacar.repository.CarRepository;
import bootcamps.turkcell.rentacar.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MaintenanceBusinessRules {
    private final MaintenanceRepository maintenanceRepository;
    private final CarRepository carRepository;

    /*public void carCannotBeCompletedWhenNotUnderMaintenance(int carId) {
        if (!maintenanceRepository.existsByCarIdAndIsCompletedFalse(carId)) {
            throw new BusinessException(ExceptionMessages.Maintenance.CAR_NOT_UNDER_MAINTENANCE);
        }
    }*/

    public void carCannotBeFinishedWhenNotUnderMaintenance(int carId) {
        if (!maintenanceRepository.existsByCarIdAndEndDateNull(carId)) {
            throw new BusinessException(ExceptionMessages.Maintenance.CAR_NOT_UNDER_MAINTENANCE);
        }
    }

    /*public void carCannotBePutUnderMaintenanceWhenUnderMaintenance(int carId) {
        if (maintenanceRepository.existsByCarIdAndIsCompletedFalse(carId)) {
            throw new BusinessException(ExceptionMessages.Maintenance.CAR_UNDER_MAINTENANCE);
        }
    }*/

    public void carCannotBePutUnderMaintenanceWhenUnderMaintenance(int carId) {
        if (maintenanceRepository.existsByCarIdAndEndDateNull(carId)) {
            throw new BusinessException(ExceptionMessages.Maintenance.CAR_UNDER_MAINTENANCE);
        }
    }

    public void carCannotBePutUnderMaintenanceWhenNotAvailable(int carId) {
        if (!carRepository.findById(carId).orElseThrow().getState().equals(CarState.AVAILABLE)) {
            throw new BusinessException(ExceptionMessages.Car.NOT_AVAILABLE);
        }
    }

}
