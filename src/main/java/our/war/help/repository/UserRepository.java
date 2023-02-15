package our.war.help.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import our.war.help.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    Boolean existsByEmail(String email);
}
