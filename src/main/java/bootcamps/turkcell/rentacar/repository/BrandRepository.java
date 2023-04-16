package bootcamps.turkcell.rentacar.repository;

import bootcamps.turkcell.rentacar.domain.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsByNameIgnoreCase(String name);
}
