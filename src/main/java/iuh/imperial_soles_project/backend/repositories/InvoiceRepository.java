package iuh.imperial_soles_project.backend.repositories;

import iuh.imperial_soles_project.backend.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}