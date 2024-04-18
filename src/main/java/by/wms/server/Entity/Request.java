package by.wms.server.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "request")
public class Request {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique=true)
    private Integer id;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private Users users;

}
