package bootcamps.turkcell.rentacar.business.rules;

import bootcamps.turkcell.core.utilities.exceptions.business.BusinessException;
import bootcamps.turkcell.rentacar.common.constants.ExceptionMessages;
import bootcamps.turkcell.rentacar.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private final BrandRepository brandRepository;

    public void checkIfBrandNameExists(String name) {
        if (brandRepository.existsByNameIgnoreCase(name)) {
            throw new BusinessException(ExceptionMessages.Brand.NAME_ALREADY_EXISTS);
        }
    }
}
