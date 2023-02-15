package our.war.help.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import our.war.help.model.Thing;
import our.war.help.model.User;

public interface ThingRepository extends JpaRepository<Thing, Long> {
    Thing findByName(String name);
}
