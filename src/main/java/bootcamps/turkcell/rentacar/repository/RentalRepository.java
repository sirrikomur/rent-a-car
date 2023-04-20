package bootcamps.turkcell.rentacar.repository;

import bootcamps.turkcell.rentacar.domain.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RentalRepository extends JpaRepository<Rental, Integer> {
    boolean existsByCarId(int carId);
    boolean existsByCarIdAndEndDateNull(int carId);

    Rental findByCarIdAndEndDateNull(int carId);
}
