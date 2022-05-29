package by.iba.repository;

import by.iba.entity.customer.Role;
import by.iba.entity.customer.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> getByTypeOfRole(RoleType typeOfRole);
}
