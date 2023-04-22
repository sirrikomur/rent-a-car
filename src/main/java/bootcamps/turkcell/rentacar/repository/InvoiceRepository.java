package bootcamps.turkcell.rentacar.repository;

import bootcamps.turkcell.rentacar.domain.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
