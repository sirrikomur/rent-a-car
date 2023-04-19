package bootcamps.turkcell.rentacar.business.rules;

import bootcamps.turkcell.core.utilities.exceptions.business.BusinessException;
import bootcamps.turkcell.rentacar.common.constants.ExceptionMessages;
import bootcamps.turkcell.rentacar.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MaintenanceBusinessRules {
    private MaintenanceRepository repository;

    public void checkIfMaintenanceExists(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(ExceptionMessages.Maintenance.NOT_EXISTS);
        }
    }

    public void checkIfCarUnderMaintenance(int carId) {
        if (!repository.existsByCarIdAndIsCompletedFalse(carId)) {
            throw new BusinessException(ExceptionMessages.Maintenance.CAR_NOT_UNDER_MAINTENANCE);
        }
    }

    public void checkIfCarNotUnderMaintenance(int carId) {
        if (repository.existsByCarIdAndIsCompletedFalse(carId)) {
            throw new BusinessException(ExceptionMessages.Maintenance.CAR_UNDER_MAINTENANCE);
        }
    }

}
