package iuh.imperial_soles_project.backend.repositories;

import iuh.imperial_soles_project.backend.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}