package iuh.imperial_soles_project.backend.repositories;

import iuh.imperial_soles_project.backend.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}