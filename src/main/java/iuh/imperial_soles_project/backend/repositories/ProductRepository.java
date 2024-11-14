package iuh.imperial_soles_project.backend.repositories;

import iuh.imperial_soles_project.backend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}