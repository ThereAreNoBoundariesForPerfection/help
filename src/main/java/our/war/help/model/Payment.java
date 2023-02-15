package our.war.help.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "payments")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sum")
    private BigDecimal sum;
    @Column(name = "date")
    private String date;
    @Column(name = "for_whom")
    private String forWhom;
    @ManyToOne(cascade = CascadeType.ALL)
    //@Column(name = "user_id")
    private User user;
}
