package our.war.help.model;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "things",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name"),
        })
@Data
public class Thing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "need_funds")
    private BigDecimal needFunds;
    @Column(name = "collected_funds")
    private BigDecimal collectedFunds;
    @Column(name = "description")
    private String description;
}
