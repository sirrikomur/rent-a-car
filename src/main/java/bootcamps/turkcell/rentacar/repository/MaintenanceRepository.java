package bootcamps.turkcell.rentacar.repository;

import bootcamps.turkcell.rentacar.domain.entities.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {
    boolean existsByCarIdAndEndDateNull(int carId);

    Maintenance findByCarIdAndEndDateNull(int carId);
}
