package bootcamps.turkcell.rentacar.business.rules;

import bootcamps.turkcell.core.utilities.exceptions.business.BusinessException;
import bootcamps.turkcell.rentacar.common.constants.ExceptionDetail;
import bootcamps.turkcell.rentacar.domain.entities.Model;
import bootcamps.turkcell.rentacar.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelBusinessRules extends BaseRules<Model> {
    private final ModelRepository repository;

    public void modelNameCannotBeRepeated(String name) {
        if (repository.existsByNameIgnoreCase(name)) {
            throw new BusinessException(ExceptionDetail.Messages.Model.NAME_ALREADY_EXISTS);
        }
    }
}
