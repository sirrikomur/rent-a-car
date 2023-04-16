package bootcamps.turkcell.rentacar.business.rules;

import bootcamps.turkcell.core.utilities.exceptions.business.BusinessException;
import bootcamps.turkcell.rentacar.common.constants.Messages;
import bootcamps.turkcell.rentacar.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarBusinessRules {
    private final CarRepository repository;

    public void checkIfLicencePlateExists(String licencePlate) {
        if (repository.existsByLicensePlateIgnoreCase(licencePlate)){
            throw new BusinessException(Messages.Car.LICENCE_PLATE_ALREADY_EXISTS);
        }
    }
}
