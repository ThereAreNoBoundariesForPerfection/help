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
    @ManyToOne(cascade = CascadeType.ALL)
    private Thing thing = null;
    @ManyToOne(cascade = CascadeType.ALL)
    private Soldier soldier = null;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
