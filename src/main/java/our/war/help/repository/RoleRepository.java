package our.war.help.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import our.war.help.model.ERole;
import our.war.help.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
