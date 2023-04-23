package bootcamps.turkcell.rentacar.business.rules;

import bootcamps.turkcell.core.utilities.exceptions.business.BusinessException;
import bootcamps.turkcell.rentacar.common.constants.ExceptionDetail;
import bootcamps.turkcell.rentacar.domain.entities.Brand;
import bootcamps.turkcell.rentacar.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules extends BaseRules<Brand> {
    private final BrandRepository brandRepository;

    public void brandNameCannotBeRepeated(String name) {
        if (brandRepository.existsByNameIgnoreCase(name)) {
            throw new BusinessException(ExceptionDetail.Messages.Brand.NAME_ALREADY_EXISTS);
        }
    }
}
