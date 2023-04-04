package bootcamps.turkcell.rentacar.repositories;

import bootcamps.turkcell.rentacar.domain.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
