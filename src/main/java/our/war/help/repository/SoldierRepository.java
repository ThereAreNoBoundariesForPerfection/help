package our.war.help.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import our.war.help.model.Soldier;

public interface SoldierRepository extends JpaRepository<Soldier, Long> {
    Soldier findByEmail(String email);
}
