package bootcamps.turkcell.rentacar.repositories;

import bootcamps.turkcell.rentacar.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
