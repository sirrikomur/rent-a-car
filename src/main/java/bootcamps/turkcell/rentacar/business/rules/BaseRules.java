package bootcamps.turkcell.rentacar.business.rules;

import bootcamps.turkcell.rentacar.common.constants.ExceptionDetail;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BaseRules<T> {

    public void idCannotBeProcessedWhenNotExists(int id, JpaRepository<T, Integer> repository) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException(ExceptionDetail.Messages.Base.ID_NOT_EXISTS);
        }
    }
}
