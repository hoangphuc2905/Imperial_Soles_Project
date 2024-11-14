package iuh.imperial_soles_project.backend.repositories;

import iuh.imperial_soles_project.backend.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}