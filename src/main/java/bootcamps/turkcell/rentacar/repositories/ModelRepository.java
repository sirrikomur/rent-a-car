package bootcamps.turkcell.rentacar.repositories;

import bootcamps.turkcell.rentacar.domain.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {

}
