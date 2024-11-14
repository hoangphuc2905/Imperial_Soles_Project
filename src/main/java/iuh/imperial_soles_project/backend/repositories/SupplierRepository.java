package iuh.imperial_soles_project.backend.repositories;

import iuh.imperial_soles_project.backend.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}