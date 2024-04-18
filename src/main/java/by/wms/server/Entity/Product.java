package by.wms.server.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "waybill")
    private Integer waybill;

    @Column(name = "length")
    private Double length;

    @Column(name = "width")
    private Double width;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "height")
    private Double height;

    @OneToMany(mappedBy = "product")
    private Collection<Box> box;

}
