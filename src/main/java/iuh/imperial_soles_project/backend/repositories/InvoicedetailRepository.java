package iuh.imperial_soles_project.backend.repositories;

import iuh.imperial_soles_project.backend.models.Invoicedetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoicedetailRepository extends JpaRepository<Invoicedetail, Integer> {
}