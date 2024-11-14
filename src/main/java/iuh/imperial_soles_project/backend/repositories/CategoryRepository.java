package iuh.imperial_soles_project.backend.repositories;

import iuh.imperial_soles_project.backend.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}