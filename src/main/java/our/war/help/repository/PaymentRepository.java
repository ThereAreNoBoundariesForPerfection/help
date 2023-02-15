package our.war.help.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import our.war.help.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
