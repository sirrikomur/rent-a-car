package bootcamps.turkcell.rentacar.business.rules;

import bootcamps.turkcell.core.utilities.exceptions.business.BusinessException;
import bootcamps.turkcell.rentacar.common.constants.ExceptionDetail;
import bootcamps.turkcell.rentacar.domain.entities.Car;
import bootcamps.turkcell.rentacar.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarBusinessRules extends BaseRules<Car> {
    private final CarRepository repository;

    public void licencePlateCannotBeRepeated(String licencePlate) {
        if (repository.existsByLicensePlateIgnoreCase(licencePlate)){
            throw new BusinessException(ExceptionDetail.Messages.Car.LICENCE_PLATE_ALREADY_EXISTS);
        }
    }
}
