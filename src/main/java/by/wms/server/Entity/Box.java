package by.wms.server.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "box")
public class Box {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "rack_id", nullable = false)
    private Rack rack;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
