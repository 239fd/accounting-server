package by.wms.acc.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "goods")
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer ID;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "length")
    private Float length;

    @Column(name = "width")
    private Float width;

    @Column(name = "height")
    private Float height;

    @Column(name = "weight")
    private Float weight;
}
