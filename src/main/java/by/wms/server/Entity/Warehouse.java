package by.wms.server.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "warehouse")
    private Collection<Rack> racks;

    @OneToMany(mappedBy = "warehouse")
    private Collection<Employees> employees;


}
